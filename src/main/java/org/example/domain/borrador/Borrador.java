package org.example.domain.borrador;

import org.example.domain.prenda.Color;
import org.example.domain.prenda.Formalidad;
import org.example.domain.prenda.Material;
import org.example.domain.prenda.Prenda;
import org.example.domain.prenda.Tipo;

public class Borrador {

  final public Tipo tipo;
  final public Material material;
  public Color colorPrimario;
  public Color colorSecundario;
  public Formalidad formalidad;
  public int indiceAbrigo;
  public boolean impermeable;

    public Borrador(Tipo tipo, Material material){
      this.tipo = tipo;
      this.material = material;
    }

    public Borrador setColorPrimario(Color colorPrimario){
      this.colorPrimario = colorPrimario;
      return this;
    }

    public Borrador setImpermeable(boolean impermeable){
      this.impermeable = impermeable;
      return this;
    }

    public Borrador setIndiceAbrigo(int indiceAbrigo){
      this.indiceAbrigo = indiceAbrigo;
      return this;
    }

    public Borrador setColorSecundario(Color colorSecundario){
      this.colorSecundario = colorSecundario;
      return this;
    }

    public void setFormalidad(Formalidad formalidad){
      this.formalidad = formalidad;
    }

  public Prenda crearPrenda(){ return new Prenda(this); }

}

//method fabricarParteSuperior()
//borrador = new Borrador(CHOMBA)
//          borrador.especificarColor(new Color(....))
//    borrador.especificarMaterial(PIQUE)
//          return borrador.crearPrenda()

