package com.demo.banco.service;

import com.demo.banco.model.UsuarioVO;
import com.demo.banco.repository.model.Usuario;

public interface UsuarioService {

  UsuarioVO buscarId(Long id);

  UsuarioVO buscarUsuario(String rut, String password);

  UsuarioVO agregarUsuario(UsuarioVO usuarioVO);

  Usuario persistirUsuario(UsuarioVO usuarioVO);

  UsuarioVO arregloUsuario(Usuario usuario);

  UsuarioVO buscarUsuarioRut(String rut);

}
