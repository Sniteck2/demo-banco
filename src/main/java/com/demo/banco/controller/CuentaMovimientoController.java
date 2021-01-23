package com.demo.banco.controller;

import com.demo.banco.model.CuentaMovimientoVO;
import com.demo.banco.model.CuentaUsuarioVO;
import com.demo.banco.service.CuentaMovimientoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("cuenta-movimiento")
public class CuentaMovimientoController {

  private final CuentaMovimientoService cuentaMovimientoService;

  @Autowired
  public CuentaMovimientoController(
      CuentaMovimientoService cuentaMovimientoService) {
    this.cuentaMovimientoService = cuentaMovimientoService;
  }

  @PostMapping(value = "/listar-movimiento/")
  List<CuentaMovimientoVO> buscarMovimiento(@RequestBody CuentaUsuarioVO cuentaUsuarioVO){
    return this.cuentaMovimientoService.buscarMovimiento(cuentaUsuarioVO);
  }

  @PostMapping(value = "/agregar-movimiento/")
  CuentaMovimientoVO agregarMovimiento(@RequestBody CuentaMovimientoVO cuentaMovimientoVO){
    return this.cuentaMovimientoService.agregarMovimiento(cuentaMovimientoVO);
  }
}
