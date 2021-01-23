package com.demo.banco.model;

import java.io.Serializable;

public class CuentaUsuarioVO implements Serializable {

  private static final long serialVersionUID = -7733966991858330100L;
  private Long id;
  private UsuarioVO usuarioVO;
  private Long monto;
  private Long activo;
  private Long tipoMovimiento;
  private Long montoAnterior;
  private CuentaMovimientoVO cuentaMovimientoVO;
  private String rutTransferir;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UsuarioVO getUsuarioVO() {
    return usuarioVO;
  }

  public void setUsuarioVO(UsuarioVO usuarioVO) {
    this.usuarioVO = usuarioVO;
  }

  public Long getMonto() {
    return monto;
  }

  public void setMonto(Long monto) {
    this.monto = monto;
  }

  public Long getActivo() {
    return activo;
  }

  public void setActivo(Long activo) {
    this.activo = activo;
  }

  public Long getTipoMovimiento() {
    return tipoMovimiento;
  }

  public void setTipoMovimiento(Long tipoMovimiento) {
    this.tipoMovimiento = tipoMovimiento;
  }

  public Long getMontoAnterior() {
    return montoAnterior;
  }

  public void setMontoAnterior(Long montoAnterior) {
    this.montoAnterior = montoAnterior;
  }

  public CuentaMovimientoVO getCuentaMovimientoVO() {
    return cuentaMovimientoVO;
  }

  public void setCuentaMovimientoVO(CuentaMovimientoVO cuentaMovimientoVO) {
    this.cuentaMovimientoVO = cuentaMovimientoVO;
  }

  public String getRutTransferir() {
    return rutTransferir;
  }

  public void setRutTransferir(String rutTransferir) {
    this.rutTransferir = rutTransferir;
  }

  @Override
  public String toString() {
    return "CuentaUsuarioVO{" +
        "id=" + id +
        ", usuarioVO=" + usuarioVO +
        ", monto=" + monto +
        ", activo=" + activo +
        ", tipoMovimiento=" + tipoMovimiento +
        ", montoAnterior=" + montoAnterior +
        ", cuentaMovimientoVO=" + cuentaMovimientoVO +
        ", rutTransferir='" + rutTransferir + '\'' +
        '}';
  }
}
