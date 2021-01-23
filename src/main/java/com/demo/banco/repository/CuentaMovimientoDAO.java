package com.demo.banco.repository;

import com.demo.banco.repository.model.CuentaMovimiento;
import com.demo.banco.repository.model.CuentaUsuario;
import java.util.List;

public interface CuentaMovimientoDAO {

  List<CuentaMovimiento> buscarMovimiento(CuentaUsuario cuentaUsuario);

  CuentaMovimiento agregarMovimiento(CuentaMovimiento cuentaMovimiento);

}
