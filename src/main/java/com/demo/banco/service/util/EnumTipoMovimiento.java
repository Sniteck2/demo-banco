package com.demo.banco.service.util;

public enum EnumTipoMovimiento {

  DEPOSITO(1L),
  RETIRO(2L),
  TRANSFERENCIA_ENTRANTE(3L),
  TRANSFERENCIA_SALIENTE(4L);

  private Long value;

  EnumTipoMovimiento(Long value) {
    this.value = value;
  }

  public Long value() {
    return this.value;
  }

  public static EnumTipoMovimiento findByValue(Long value){
    for(EnumTipoMovimiento tipo : EnumTipoMovimiento.values()){
      if(tipo.value.equals(value)){
        return tipo;
      }
    }
    return null;
  }

}
