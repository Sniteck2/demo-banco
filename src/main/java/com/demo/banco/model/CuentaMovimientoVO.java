package com.demo.banco.model;

import java.io.Serializable;
import java.util.Date;

public class CuentaMovimientoVO implements Serializable {

  private static final long serialVersionUID = -4498699380568465381L;
  private Long id;
  private CuentaUsuarioVO cuentaUsuario;
  private Long tipoMovimiento;
  private String desde;
  private String hasta;
  private Long montoMovimiento;
  private Long montoRestante;
  private Date fechaMovimiento;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CuentaUsuarioVO getCuentaUsuario() {
    return cuentaUsuario;
  }

  public void setCuentaUsuario(CuentaUsuarioVO cuentaUsuario) {
    this.cuentaUsuario = cuentaUsuario;
  }

  public Long getTipoMovimiento() {
    return tipoMovimiento;
  }

  public void setTipoMovimiento(Long tipoMovimiento) {
    this.tipoMovimiento = tipoMovimiento;
  }

  public String getDesde() {
    return desde;
  }

  public void setDesde(String desde) {
    this.desde = desde;
  }

  public String getHasta() {
    return hasta;
  }

  public void setHasta(String hasta) {
    this.hasta = hasta;
  }

  public Long getMontoMovimiento() {
    return montoMovimiento;
  }

  public void setMontoMovimiento(Long montoMovimiento) {
    this.montoMovimiento = montoMovimiento;
  }

  public Long getMontoRestante() {
    return montoRestante;
  }

  public void setMontoRestante(Long montoRestante) {
    this.montoRestante = montoRestante;
  }

  public Date getFechaMovimiento() {
    return fechaMovimiento;
  }

  public void setFechaMovimiento(Date fechaMovimiento) {
    this.fechaMovimiento = fechaMovimiento;
  }

  @Override
  public String toString() {
    return "CuentaMovimientoVO{" +
        "id=" + id +
        ", cuentaUsuario=" + cuentaUsuario +
        ", tipoMovimiento=" + tipoMovimiento +
        ", desde='" + desde + '\'' +
        ", hasta='" + hasta + '\'' +
        ", montoMovimiento=" + montoMovimiento +
        ", montoRestante=" + montoRestante +
        ", fechaMovimiento=" + fechaMovimiento +
        '}';
  }
}
