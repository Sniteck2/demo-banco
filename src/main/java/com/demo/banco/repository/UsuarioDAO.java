package com.demo.banco.repository;

import com.demo.banco.repository.model.Usuario;

public interface UsuarioDAO {

  Usuario buscarId(Long id);

  Usuario buscarUsuario(String rut, String password);

  Usuario agregarUsuario(Usuario usuario);

  Usuario buscarUsuarioRut(String rut);

}
