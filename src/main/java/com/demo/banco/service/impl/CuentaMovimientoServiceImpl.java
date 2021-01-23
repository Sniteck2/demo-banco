package com.demo.banco.service.impl;

import com.demo.banco.model.CuentaMovimientoVO;
import com.demo.banco.model.CuentaUsuarioVO;
import com.demo.banco.repository.CuentaMovimientoDAO;
import com.demo.banco.repository.model.CuentaMovimiento;
import com.demo.banco.repository.model.CuentaUsuario;
import com.demo.banco.service.CuentaMovimientoService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CuentaMovimientoServiceImpl implements CuentaMovimientoService {

  private final CuentaMovimientoDAO cuentaMovimientoDAO;

  @Autowired
  public CuentaMovimientoServiceImpl(
      CuentaMovimientoDAO cuentaMovimientoDAO) {
    this.cuentaMovimientoDAO = cuentaMovimientoDAO;
  }

  @Override
  public List<CuentaMovimientoVO> buscarMovimiento(CuentaUsuarioVO cuentaUsuarioVO) {
    List<CuentaMovimiento> cuentaMovimientos;
    List<CuentaMovimientoVO> cuentaMovimientoVOS = new ArrayList<>();
    CuentaUsuario cuentaUsuario = new CuentaUsuario();
    cuentaUsuario.setId(cuentaUsuarioVO.getId());
    cuentaMovimientos = this.cuentaMovimientoDAO.buscarMovimiento(cuentaUsuario);
    for(CuentaMovimiento cuenta: cuentaMovimientos){
      cuentaMovimientoVOS.add(this.arregloCuentaMovimiento(cuenta));
    }
    return cuentaMovimientoVOS;
  }

  @Override
  @Transactional
  public CuentaMovimientoVO agregarMovimiento(CuentaMovimientoVO cuentaMovimientoVO) {
    CuentaMovimiento cuentaMovimiento = this.persistirCuentaMovimiento(cuentaMovimientoVO);
    CuentaMovimiento nuevoMovimiento = this.cuentaMovimientoDAO.agregarMovimiento(cuentaMovimiento);
    return this.arregloCuentaMovimiento(nuevoMovimiento);
  }

  @Override
  public CuentaMovimientoVO arregloCuentaMovimiento(CuentaMovimiento cuentaMovimiento) {
    CuentaMovimientoVO cuentaMovimientoVO = new CuentaMovimientoVO();
    if(cuentaMovimiento.getId() != null){
      cuentaMovimientoVO.setId(cuentaMovimiento.getId());
      CuentaUsuarioVO cuentaUsuario = new CuentaUsuarioVO();
      cuentaUsuario.setId(cuentaMovimiento.getCuentaUsuario().getId());
      cuentaMovimientoVO.setCuentaUsuario(cuentaUsuario);
      cuentaMovimientoVO.setTipoMovimiento(cuentaMovimiento.getTipoMovimiento());
      cuentaMovimientoVO.setDesde(cuentaMovimiento.getDesde());
      cuentaMovimientoVO.setHasta(cuentaMovimiento.getHasta());
      cuentaMovimientoVO.setMontoMovimiento(cuentaMovimiento.getMontoMovimiento());
      cuentaMovimientoVO.setMontoRestante(cuentaMovimiento.getMontoRestante());
      cuentaMovimientoVO.setFechaMovimiento(new Date());
    }
    return cuentaMovimientoVO;
  }

  @Override
  public CuentaMovimiento persistirCuentaMovimiento(CuentaMovimientoVO cuentaMovimientoVO) {
    CuentaMovimiento cuentaMovimiento = new CuentaMovimiento();
    if(cuentaMovimientoVO.getCuentaUsuario().getId() != null){
      CuentaUsuario cuentaUsuario = new CuentaUsuario();
      cuentaUsuario.setId(cuentaMovimientoVO.getCuentaUsuario().getId());
      cuentaMovimiento.setCuentaUsuario(cuentaUsuario);
      cuentaMovimiento.setTipoMovimiento(cuentaMovimientoVO.getTipoMovimiento());
      cuentaMovimiento.setDesde(cuentaMovimientoVO.getDesde());
      cuentaMovimiento.setHasta(cuentaMovimientoVO.getHasta());
      cuentaMovimiento.setMontoMovimiento(cuentaMovimientoVO.getMontoMovimiento());
      cuentaMovimiento.setMontoRestante(cuentaMovimientoVO.getMontoRestante());
      cuentaMovimiento.setFechaMovimiento(new Date());
    }
    return cuentaMovimiento;
  }


}
