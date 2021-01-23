package com.demo.banco.service.impl;

import com.demo.banco.model.UsuarioVO;
import com.demo.banco.repository.UsuarioDAO;
import com.demo.banco.repository.model.Usuario;
import com.demo.banco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  private final UsuarioDAO usuarioDAO;

  @Autowired
  public UsuarioServiceImpl(UsuarioDAO usuarioDAO) {
    this.usuarioDAO = usuarioDAO;
  }

  @Override
  public UsuarioVO buscarId(Long id) {
    Usuario usuario = usuarioDAO.buscarId(id);
    return this.arregloUsuario(usuario);
  }

  @Override
  public UsuarioVO buscarUsuario(String rut, String password) {
    Usuario usuario = new Usuario();
    if(rut != null && password != null){
      usuario = usuarioDAO.buscarUsuario(rut, password);
    }
    return this.arregloUsuario(usuario);
  }

  @Override
  @Transactional
  public UsuarioVO agregarUsuario(UsuarioVO usuarioVO) {
    Usuario usuario = this.persistirUsuario(usuarioVO);
    Usuario receptor = this.usuarioDAO.agregarUsuario(usuario);
    return this.arregloUsuario(receptor);
  }

  @Override
  public Usuario persistirUsuario(UsuarioVO usuarioVO) {
    Usuario usuario = new Usuario();
    if(usuarioVO.getRut() != null){
      usuario.setNombre(usuarioVO.getNombre());
      usuario.setAppPaterno(usuarioVO.getAppPaterno());
      usuario.setAppMaterno(usuarioVO.getAppMaterno());
      usuario.setRut(usuarioVO.getRut());
      usuario.setCorreo(usuarioVO.getCorreo());
      usuario.setPassword(usuarioVO.getPassword());
      usuario.setActivo(1L);
    }
    return usuario;
  }

  @Override
  public UsuarioVO arregloUsuario(Usuario usuario) {
    UsuarioVO usuarioVO = new UsuarioVO();
    if(usuario.getId() != null){
      usuarioVO.setId(usuario.getId());
      usuarioVO.setNombre(usuario.getNombre());
      usuarioVO.setAppPaterno(usuario.getAppPaterno());
      usuarioVO.setAppMaterno(usuario.getAppMaterno());
      usuarioVO.setRut(usuario.getRut());
      usuarioVO.setCorreo(usuario.getCorreo());
      usuarioVO.setPassword(usuario.getPassword());
      usuarioVO.setActivo(usuario.getActivo());
    }
    return usuarioVO;
  }

  @Override
  public UsuarioVO buscarUsuarioRut(String rut) {
    Usuario usuario = new Usuario();
    if(rut != null){
      usuario = this.usuarioDAO.buscarUsuarioRut(rut);
    }
    return this.arregloUsuario(usuario);
  }
}
