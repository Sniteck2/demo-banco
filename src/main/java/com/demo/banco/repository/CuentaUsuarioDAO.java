package com.demo.banco.repository;

import com.demo.banco.repository.model.CuentaUsuario;
import com.demo.banco.repository.model.Usuario;

public interface CuentaUsuarioDAO {

  CuentaUsuario buscarId(Long id);

  CuentaUsuario buscarCuenta(Usuario usuario);

  CuentaUsuario agregarCuenta(CuentaUsuario cuentaUsuario);

}
