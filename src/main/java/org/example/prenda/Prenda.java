package org.example.prenda;

import org.example.borrador.Borrador;

public class Prenda {


  private Tipo tipo;
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;
  private Formalidad formalidad;

  //constructor
  public Prenda(Borrador borrador){
    this.tipo = borrador.tipo;
    this.colorPrimario = borrador.colorPrimario;
    this.colorSecundario = borrador.colorSecundario;
    this.material = borrador.material;
    this.formalidad = borrador.formalidad;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public Formalidad getFormalidad() {
    return formalidad;
  }

  public Color getColorPrimario() { return colorPrimario; }

  public Material.TipoMaterial getMaterial() { return material.tipoMaterial; }


  // ------------------------------------------------------------------

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
    return Tipo.Categoria.ACCESORIO == tipo.getCategoria();
  }

}
