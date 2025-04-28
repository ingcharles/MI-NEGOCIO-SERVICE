package ec.gob.imark.catalogo.enumeration;

import lombok.Getter;

@Getter
public enum TipoEnum {
  P(""), NP(""), Q(""), AD("");

  private final String tipo;

  TipoEnum(String tipo) {
    this.tipo = tipo;
  }
}
