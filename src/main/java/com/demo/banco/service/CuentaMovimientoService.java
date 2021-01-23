package com.demo.banco.service;

import com.demo.banco.model.CuentaMovimientoVO;
import com.demo.banco.model.CuentaUsuarioVO;
import com.demo.banco.repository.model.CuentaMovimiento;
import java.util.List;

public interface CuentaMovimientoService {

  List<CuentaMovimientoVO> buscarMovimiento(CuentaUsuarioVO cuentaUsuarioVO);

  CuentaMovimientoVO agregarMovimiento(CuentaMovimientoVO cuentaMovimientoVO);

  CuentaMovimientoVO arregloCuentaMovimiento(CuentaMovimiento cuentaMovimiento);

  CuentaMovimiento persistirCuentaMovimiento(CuentaMovimientoVO cuentaMovimientoVO);

}
