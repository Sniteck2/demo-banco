package com.demo.banco.model;

import java.io.Serializable;

public class UsuarioVO implements Serializable {

  private static final long serialVersionUID = -8638230880990829039L;
  private Long id;
  private String nombre;
  private String appPaterno;
  private String appMaterno;
  private String rut;
  private String correo;
  private String password;
  private Long activo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getAppPaterno() {
    return appPaterno;
  }

  public void setAppPaterno(String appPaterno) {
    this.appPaterno = appPaterno;
  }

  public String getAppMaterno() {
    return appMaterno;
  }

  public void setAppMaterno(String appMaterno) {
    this.appMaterno = appMaterno;
  }

  public String getRut() {
    return rut;
  }

  public void setRut(String rut) {
    this.rut = rut;
  }

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Long getActivo() {
    return activo;
  }

  public void setActivo(Long activo) {
    this.activo = activo;
  }
}
