package org.example.domain.prenda;

import org.example.domain.borrador.Borrador;

public class Prenda {


  private Tipo tipo;
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;
  private Formalidad formalidad;
  private int indiceAbrigo; // [1...10]
  private boolean impermeable;

  //constructor
  public Prenda(Borrador borrador){
    this.tipo = borrador.tipo;
    this.colorPrimario = borrador.colorPrimario;
    this.colorSecundario = borrador.colorSecundario;
    this.material = borrador.material;
    this.formalidad = borrador.formalidad;
    this.impermeable = borrador.impermeable;
    this.indiceAbrigo = borrador.indiceAbrigo;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public Formalidad getFormalidad() {
    return formalidad;
  }

  public Color getColorPrimario() { return colorPrimario; }

  public Material.TipoMaterial getMaterial() { return material.tipoMaterial; }

  public int getIndiceAbrigo() { return indiceAbrigo; }


  // ------------------------------------------------------------------

  public boolean esImpermeable() { return impermeable; }

  public Boolean esFormal() {
    return Formalidad.FORMAL == formalidad;
  }

  public Boolean esSuperior() {
    return Tipo.Categoria.PARTE_SUPERIOR == tipo.getCategoria();
  }

  public Boolean esInferior() {
    return Tipo.Categoria.PARTE_INFERIOR == tipo.getCategoria();
  }

  public Boolean esCalzado() {
    return Tipo.Categoria.CALZADO == tipo.getCategoria();
  }

  public Boolean esAccesorio() {
    return Tipo.Categoria.ACCESORIO == getTipo().getCategoria();
  }

}
