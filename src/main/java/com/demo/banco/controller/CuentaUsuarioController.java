package com.demo.banco.controller;

import com.demo.banco.model.CuentaUsuarioVO;
import com.demo.banco.model.UsuarioVO;
import com.demo.banco.service.CuentaUsuarioService;
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
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RequestMapping("cuenta-usuario")
public class CuentaUsuarioController {

  private final CuentaUsuarioService cuentaUsuarioService;

  @Autowired
  public CuentaUsuarioController(CuentaUsuarioService cuentaUsuarioService) {
    this.cuentaUsuarioService = cuentaUsuarioService;
  }

  @GetMapping(value = "/buscar-id/{id}")
  CuentaUsuarioVO buscarId(@PathVariable("id") Long id){
    return this.cuentaUsuarioService.buscarId(id);
  }

  @PostMapping(value = "/buscar-cuenta/", consumes = "application/json; charset=utf-8")
  CuentaUsuarioVO buscarCuenta(@RequestBody UsuarioVO usuarioVO){
    return this.cuentaUsuarioService.buscarCuenta(usuarioVO);
  }

  @PostMapping(value = "/agregar-cuenta/", consumes = "application/json; charset=utf-8")
  CuentaUsuarioVO agregarCuenta(@RequestBody CuentaUsuarioVO cuentaUsuarioVO){
    return this.cuentaUsuarioService.agregarCuenta(cuentaUsuarioVO);
  }

  @PostMapping(value = "/modificar-cuenta/", consumes = "application/json; charset=utf-8")
  CuentaUsuarioVO modificarCuenta(@RequestBody CuentaUsuarioVO cuentaUsuarioVO){
    return this.cuentaUsuarioService.modificarCuenta(cuentaUsuarioVO);
  }

}
