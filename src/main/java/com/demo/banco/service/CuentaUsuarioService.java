package com.demo.banco.service;

import com.demo.banco.model.CuentaMovimientoVO;
import com.demo.banco.model.CuentaUsuarioVO;
import com.demo.banco.model.UsuarioVO;
import com.demo.banco.repository.model.CuentaUsuario;

public interface CuentaUsuarioService {

  CuentaUsuarioVO buscarId(Long id);

  CuentaUsuarioVO buscarCuenta(UsuarioVO usuarioVO);

  CuentaUsuarioVO agregarCuenta(CuentaUsuarioVO cuentaUsuario);

  CuentaUsuarioVO modificarCuenta(CuentaUsuarioVO cuentaUsuarioVO);

  CuentaUsuario persistirCuentaUsuario(CuentaUsuarioVO cuentaUsuarioVO);

  CuentaUsuarioVO arregloCuentaUsuarioVO(CuentaUsuario cuentaUsuario);

  CuentaMovimientoVO arregloCuentaMovimiento(CuentaUsuarioVO cuentaUsuarioVO);

}
