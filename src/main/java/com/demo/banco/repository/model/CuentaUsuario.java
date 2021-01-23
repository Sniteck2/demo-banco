package com.demo.banco.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUENTA_USUARIO")
public class CuentaUsuario {

  private Long id;
  private Usuario usuario;
  private Long monto;
  private Long activo;

  public CuentaUsuario() {
  }

  public CuentaUsuario(Long id, Usuario usuario, Long monto, Long activo) {
    this.id = id;
    this.usuario = usuario;
    this.monto = monto;
    this.activo = activo;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CRR_CUENTA_USUARIO")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @ManyToOne
  @JoinColumn(name = "CRR_USUARIO")
  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  @Column(name = "MONTO")
  public Long getMonto() {
    return monto;
  }

  public void setMonto(Long monto) {
    this.monto = monto;
  }

  @Column(name = "ACTIVO")
  public Long getActivo() {
    return activo;
  }

  public void setActivo(Long activo) {
    this.activo = activo;
  }

  @Override
  public String toString() {
    return "CuentaUsuario{" +
        "id=" + id +
        ", usuario=" + usuario +
        ", monto=" + monto +
        ", activo=" + activo +
        '}';
  }
}
