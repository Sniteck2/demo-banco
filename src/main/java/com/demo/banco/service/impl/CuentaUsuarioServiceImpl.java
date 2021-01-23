package com.demo.banco.service.impl;

import com.demo.banco.model.CuentaMovimientoVO;
import com.demo.banco.model.CuentaUsuarioVO;
import com.demo.banco.model.UsuarioVO;
import com.demo.banco.repository.CuentaUsuarioDAO;
import com.demo.banco.repository.model.CuentaUsuario;
import com.demo.banco.repository.model.Usuario;
import com.demo.banco.service.CuentaMovimientoService;
import com.demo.banco.service.CuentaUsuarioService;
import com.demo.banco.service.UsuarioService;
import com.demo.banco.service.util.EnumTipoMovimiento;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuentaUsuarioServiceImpl implements CuentaUsuarioService {

  private final Log logger = LogFactory.getLog("CuentaUsuarioService");
  private final CuentaUsuarioDAO cuentaUsuarioDAO;
  private final CuentaMovimientoService cuentaMovimientoService;
  private final UsuarioService usuarioService;

  @Autowired
  public CuentaUsuarioServiceImpl(CuentaUsuarioDAO cuentaUsuarioDAO,
      CuentaMovimientoService cuentaMovimientoService,
      UsuarioService usuarioService) {
    this.cuentaUsuarioDAO = cuentaUsuarioDAO;
    this.cuentaMovimientoService = cuentaMovimientoService;
    this.usuarioService = usuarioService;
  }

  @Override
  public CuentaUsuarioVO buscarId(Long id) {
    CuentaUsuario cuentaUsuario = this.cuentaUsuarioDAO.buscarId(id);
    return this.arregloCuentaUsuarioVO(cuentaUsuario);
  }

  @Override
  public CuentaUsuarioVO buscarCuenta(UsuarioVO usuarioVO) {
    CuentaUsuarioVO cuentaUsuarioVO = new CuentaUsuarioVO();
    Usuario usuario = new Usuario();
    usuario.setId(usuarioVO.getId());
    CuentaUsuario cuentaUsuario = this.cuentaUsuarioDAO.buscarCuenta(usuario);
    if(cuentaUsuario.getId() == -1){
      cuentaUsuarioVO.setId(-1L);
    }else{
      cuentaUsuarioVO = this.arregloCuentaUsuarioVO(cuentaUsuario);
    }
    return cuentaUsuarioVO;
  }

  @Override
  @Transactional
  public CuentaUsuarioVO agregarCuenta(CuentaUsuarioVO cuentaUsuarioVO) {
    CuentaUsuario cuentaUsuario = this.persistirCuentaUsuario(cuentaUsuarioVO);
    CuentaUsuario nuevaCuenta = this.cuentaUsuarioDAO.agregarCuenta(cuentaUsuario);
    return this.arregloCuentaUsuarioVO(nuevaCuenta);
  }

  @Override
  @Transactional
  public CuentaUsuarioVO modificarCuenta(CuentaUsuarioVO cuentaUsuarioVO) {
    CuentaUsuarioVO nuevaCuenta = new CuentaUsuarioVO();
    Usuario usuario = new Usuario();
    usuario.setId(cuentaUsuarioVO.getUsuarioVO().getId());
    usuario.setRut(cuentaUsuarioVO.getUsuarioVO().getRut());
    CuentaUsuario cuentaUsuario = this.cuentaUsuarioDAO.buscarCuenta(usuario);
    if(cuentaUsuario.getId() != -1){

      if(cuentaUsuarioVO.getTipoMovimiento().equals(EnumTipoMovimiento.DEPOSITO.value())){

        nuevaCuenta.setId(cuentaUsuario.getId());
        nuevaCuenta.setTipoMovimiento(cuentaUsuarioVO.getTipoMovimiento());
        nuevaCuenta.setMonto(cuentaUsuarioVO.getMonto());
        Long deposito = cuentaUsuario.getMonto() + cuentaUsuarioVO.getMonto();
        nuevaCuenta.setMontoAnterior(deposito);
        cuentaUsuario.setMonto(deposito);
        try{
          CuentaMovimientoVO cuentaMovimientoVO = this.arregloCuentaMovimiento(nuevaCuenta);
          this.cuentaMovimientoService.agregarMovimiento(cuentaMovimientoVO);
        }catch(Exception ex){
          logger.warn("Error: " + ex.getLocalizedMessage());
        }
      }else if (cuentaUsuarioVO.getTipoMovimiento().equals(EnumTipoMovimiento.RETIRO.value())){

        Long retiro = cuentaUsuario.getMonto() - cuentaUsuarioVO.getMonto();
        if(retiro >= 0){
          nuevaCuenta.setId(cuentaUsuario.getId());
          nuevaCuenta.setTipoMovimiento(cuentaUsuarioVO.getTipoMovimiento());
          nuevaCuenta.setMontoAnterior(retiro);
          nuevaCuenta.setMonto(cuentaUsuarioVO.getMonto());
          cuentaUsuario.setMonto(retiro);
        }
        try{
          CuentaMovimientoVO cuentaMovimientoVO = this.arregloCuentaMovimiento(nuevaCuenta);
          this.cuentaMovimientoService.agregarMovimiento(cuentaMovimientoVO);
        }catch(Exception ex){
          logger.warn("Error: " + ex.getLocalizedMessage());
        }
      }else if (cuentaUsuarioVO.getTipoMovimiento().equals(EnumTipoMovimiento.TRANSFERENCIA_SALIENTE.value())){

        Long retiro = cuentaUsuario.getMonto() - cuentaUsuarioVO.getMonto();
        if(retiro >= 0){
          nuevaCuenta.setId(cuentaUsuario.getId());
          nuevaCuenta.setTipoMovimiento(cuentaUsuarioVO.getTipoMovimiento());
          nuevaCuenta.setMontoAnterior(retiro);
          nuevaCuenta.setMonto(cuentaUsuarioVO.getMonto());
          nuevaCuenta.setRutTransferir(cuentaUsuarioVO.getRutTransferir());
          UsuarioVO usuarioVO = new UsuarioVO();
          usuarioVO.setRut(cuentaUsuario.getUsuario().getRut());
          nuevaCuenta.setUsuarioVO(usuarioVO);
          cuentaUsuario.setMonto(retiro);
        }
        try{
          CuentaMovimientoVO cuentaMovimientoVO = this.arregloCuentaMovimiento(nuevaCuenta);
          this.cuentaMovimientoService.agregarMovimiento(cuentaMovimientoVO);
        }catch(Exception ex){
          logger.warn("Error: " + ex.getLocalizedMessage());
        }
      }else{
        nuevaCuenta.setId(-1L);
      }
    }
    return nuevaCuenta;
  }

  @Override
  public CuentaUsuario persistirCuentaUsuario(CuentaUsuarioVO cuentaUsuarioVO) {
    CuentaUsuario cuentaUsuario = new CuentaUsuario();
    if(cuentaUsuarioVO.getUsuarioVO().getId() != null){
      Usuario usuario = new Usuario();
      usuario.setId(cuentaUsuarioVO.getUsuarioVO().getId());
      cuentaUsuario.setUsuario(usuario);
      cuentaUsuario.setMonto(0L);
      cuentaUsuario.setActivo(1L);
    }
    return cuentaUsuario;
  }

  @Override
  public CuentaUsuarioVO arregloCuentaUsuarioVO(CuentaUsuario cuentaUsuario) {
    CuentaUsuarioVO cuentaUsuarioVO = new CuentaUsuarioVO();
    if(cuentaUsuario != null){
      UsuarioVO usuarioVO = new UsuarioVO();
      usuarioVO.setId(cuentaUsuario.getUsuario().getId());
      cuentaUsuarioVO.setId(cuentaUsuario.getId());
      cuentaUsuarioVO.setUsuarioVO(usuarioVO);
      cuentaUsuarioVO.setMonto(cuentaUsuario.getMonto());
    }else{
      cuentaUsuarioVO.setId(-1L);
    }
    return cuentaUsuarioVO;
  }

  @Override
  public CuentaMovimientoVO arregloCuentaMovimiento(CuentaUsuarioVO cuentaUsuarioVO) {
    CuentaMovimientoVO cuentaMovimientoVO = new CuentaMovimientoVO();
    cuentaMovimientoVO.setCuentaUsuario(cuentaUsuarioVO);
    cuentaMovimientoVO.setMontoMovimiento(cuentaUsuarioVO.getMonto());
    cuentaMovimientoVO.setTipoMovimiento(cuentaUsuarioVO.getTipoMovimiento());
    if(cuentaUsuarioVO.getTipoMovimiento().equals(EnumTipoMovimiento.DEPOSITO.value())){
      cuentaMovimientoVO.setMontoRestante(cuentaUsuarioVO.getMontoAnterior());
    }else if (cuentaUsuarioVO.getTipoMovimiento().equals(EnumTipoMovimiento.RETIRO.value())){
      cuentaMovimientoVO.setMontoRestante(cuentaUsuarioVO.getMontoAnterior());
    }else if (cuentaUsuarioVO.getTipoMovimiento().equals(EnumTipoMovimiento.TRANSFERENCIA_SALIENTE.value())
    || cuentaUsuarioVO.getTipoMovimiento().equals(EnumTipoMovimiento.TRANSFERENCIA_ENTRANTE.value())){
      cuentaMovimientoVO.setDesde(cuentaUsuarioVO.getUsuarioVO().getRut());
      cuentaMovimientoVO.setHasta(cuentaUsuarioVO.getRutTransferir());
      cuentaMovimientoVO.setMontoRestante(cuentaUsuarioVO.getMontoAnterior());
    }

    return cuentaMovimientoVO;
  }

  private UsuarioVO aTransferir(CuentaUsuarioVO cuentaUsuarioVO){
    UsuarioVO usuarioVO = this.usuarioService.buscarUsuarioRut(cuentaUsuarioVO.getRutTransferir());
    return usuarioVO;
  }
}
