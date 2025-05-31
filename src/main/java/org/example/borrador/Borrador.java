package org.example.borrador;

import org.example.prenda.Color;
import org.example.prenda.Formalidad;
import org.example.prenda.Material;
import org.example.prenda.Prenda;
import org.example.prenda.Tipo;

public class Borrador {

  final public Tipo tipo;
  final public Material material;
  public Color colorPrimario;
  public Color colorSecundario;
  public Formalidad formalidad;

    public Borrador(Tipo tipo, Material material){
      this.tipo = tipo;
      this.material = material;
    }

    public Borrador setColorPrimario(Color colorPrimario){
      this.colorPrimario = colorPrimario;
      return this;
    }

    public Borrador setColorSecundario(Color colorSecundario){
      this.colorSecundario = colorSecundario;
      return this;
    }

    public Borrador setFormalidad(Formalidad formalidad){
      this.formalidad = formalidad;
      return this;
    }



  public Prenda crearPrenda(){ return new Prenda(this); }

}

//method fabricarParteSuperior()
//borrador = new Borrador(CHOMBA)
//          borrador.especificarColor(new Color(....))
//    borrador.especificarMaterial(PIQUE)
//          return borrador.crearPrenda()

