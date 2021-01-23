package com.demo.banco.repository.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TREL_CUENTA_MOVIMIENTO")
public class CuentaMovimiento {

  private Long id;
  private CuentaUsuario cuentaUsuario;
  private Long tipoMovimiento;
  private String desde;
  private String hasta;
  private Long montoMovimiento;
  private Long montoRestante;
  private Date fechaMovimiento;

  public CuentaMovimiento() {
  }

  public CuentaMovimiento(Long id, CuentaUsuario cuentaUsuario, Long tipoMovimiento,
      String desde, String hasta, Long montoMovimiento, Long montoRestante,
      Date fechaMovimiento) {
    this.id = id;
    this.cuentaUsuario = cuentaUsuario;
    this.tipoMovimiento = tipoMovimiento;
    this.desde = desde;
    this.hasta = hasta;
    this.montoMovimiento = montoMovimiento;
    this.montoRestante = montoRestante;
    this.fechaMovimiento = fechaMovimiento;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CRR_CUENTA_MOVIMIENTO")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @ManyToOne
  @JoinColumn(name = "CRR_CUENTA_USUARIO")
  public CuentaUsuario getCuentaUsuario() {
    return cuentaUsuario;
  }

  public void setCuentaUsuario(CuentaUsuario cuentaUsuario) {
    this.cuentaUsuario = cuentaUsuario;
  }

  @Column(name = "COD_TIPO_MOVIMIENTO")
  public Long getTipoMovimiento() {
    return tipoMovimiento;
  }

  public void setTipoMovimiento(Long tipoMovimiento) {
    this.tipoMovimiento = tipoMovimiento;
  }

  @Column(name = "DESDE")
  public String getDesde() {
    return desde;
  }

  public void setDesde(String desde) {
    this.desde = desde;
  }

  @Column(name = "HACIA")
  public String getHasta() {
    return hasta;
  }

  public void setHasta(String hasta) {
    this.hasta = hasta;
  }

  @Column(name = "MONTO_MOVIMIENTO")
  public Long getMontoMovimiento() {
    return montoMovimiento;
  }

  public void setMontoMovimiento(Long montoMovimiento) {
    this.montoMovimiento = montoMovimiento;
  }

  @Column(name = "MONTO_RESTANTE")
  public Long getMontoRestante() {
    return montoRestante;
  }

  public void setMontoRestante(Long montoRestante) {
    this.montoRestante = montoRestante;
  }

  @Column(name = "FECHA_MOVIMIENTO")
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
