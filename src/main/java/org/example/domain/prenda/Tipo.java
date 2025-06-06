package org.example.domain.prenda;

public enum Tipo {                //Los enums son objetos que pueden tener comportamiento y atributos!!!!

  CAMISA(Categoria.PARTE_SUPERIOR),
  PANTALON(Categoria.PARTE_INFERIOR),
  ZAPATO(Categoria.CALZADO),
  CHOMBA(Categoria.PARTE_SUPERIOR),
  BERMUDA(Categoria.PARTE_INFERIOR),
  REMERA(Categoria.PARTE_SUPERIOR),
  BUFANDA(Categoria.ACCESORIO),
  BORCEGOS(Categoria.CALZADO),
  BOTAS(Categoria.CALZADO),
  ZAPATILLAS(Categoria.CALZADO),
  CAMPERA(Categoria.PARTE_SUPERIOR),
  BUZO(Categoria.PARTE_SUPERIOR),
  RELOJ(Categoria.ACCESORIO);

  // Atributo del enum
  private Categoria categoria;

  // Constructor
  Tipo(Categoria categoria) {
    this.categoria = categoria;
  }

  // Getter
  public Categoria getCategoria() {return categoria;}

  // Enum anidad(categorias)
  public enum Categoria {CALZADO, PARTE_SUPERIOR, PARTE_INFERIOR, ACCESORIO;}
}