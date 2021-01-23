package com.demo.banco.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {

  private Long id;
  private String nombre;
  private String appPaterno;
  private String appMaterno;
  private String rut;
  private String correo;
  private String password;
  private Long activo;

  public Usuario() {
  }

  public Usuario(Long id, String nombre, String appPaterno, String appMaterno, String rut,
      String correo, String password, Long activo) {
    this.id = id;
    this.nombre = nombre;
    this.appPaterno = appPaterno;
    this.appMaterno = appMaterno;
    this.rut = rut;
    this.correo = correo;
    this.password = password;
    this.activo = activo;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CRR_USUARIO")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "NOMBRE")
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Column(name = "APP_PATERNO")
  public String getAppPaterno() {
    return appPaterno;
  }

  public void setAppPaterno(String appPaterno) {
    this.appPaterno = appPaterno;
  }

  @Column(name = "APP_MATERNO")
  public String getAppMaterno() {
    return appMaterno;
  }

  public void setAppMaterno(String appMaterno) {
    this.appMaterno = appMaterno;
  }

  @Column(name = "RUT")
  public String getRut() {
    return rut;
  }

  public void setRut(String rut) {
    this.rut = rut;
  }

  @Column(name = "CORREO")
  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  @Column(name = "PASSWORD")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
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
    return "Usuario{" +
        "id=" + id +
        ", nombre='" + nombre + '\'' +
        ", appPaterno='" + appPaterno + '\'' +
        ", appMaterno='" + appMaterno + '\'' +
        ", rut='" + rut + '\'' +
        ", correo='" + correo + '\'' +
        ", password='" + password + '\'' +
        ", activo=" + activo +
        '}';
  }
}
