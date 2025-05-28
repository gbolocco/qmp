package org.example.prenda;

import org.example.borrador.Borrador;

public class Prenda {


  private Tipo tipo;
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;

  //constructor
  public Prenda(Borrador borrador){
    this.tipo = borrador.tipo;
    this.colorPrimario = borrador.colorPrimario;
    this.colorSecundario = borrador.colorSecundario;
    this.material = borrador.material;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public Color getColorPrimario() { return colorPrimario; }

  public Material.TipoMaterial getMaterial() { return material.tipoMaterial; }

}

// >> Prenda camisa = new Prenda(Tipo.CAMISA, Color.ROJO,null, Material.TELA);
