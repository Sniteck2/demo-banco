package com.demo.banco.controller;

import com.demo.banco.model.UsuarioVO;
import com.demo.banco.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("usuario")
public class UsuarioController {

  private final UsuarioService usuarioService;

  @Autowired
  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @GetMapping(value= "/buscar-id/{id}")
  UsuarioVO buscarId(@PathVariable("id") Long id){
    return this.usuarioService.buscarId(id);
  }

  @PostMapping(value = "/buscar-usuario/", consumes = "application/json; charset=utf-8")
  UsuarioVO buscarUsuario(@RequestBody UsuarioVO usuarioVO){
    return this.usuarioService.buscarUsuario(usuarioVO.getRut(), usuarioVO.getPassword());
  }

  @PostMapping(value = "/agregar-usuario/", consumes = "application/json; charset=utf-8")
  UsuarioVO agregarUsuario(@RequestBody UsuarioVO usuarioVO){
    return this.usuarioService.agregarUsuario(usuarioVO);
  }

  @GetMapping(value = "/buscar-usuario-rut/{rut}")
  UsuarioVO buscarUsuarioRut(@PathVariable("rut") String rut){
    return this.usuarioService.buscarUsuarioRut(rut);
  }
}
