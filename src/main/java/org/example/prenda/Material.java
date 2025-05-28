package org.example.prenda;

public class Material {

  public enum Trama {LISA, RAYADA, LUNARES, CUADROS, ESTAMPADO,PIQUE}
  public enum TipoMaterial {ALGODON, TELA, CUERO, ACETATO, DE_VESTIR}

  public Trama trama = Trama.LISA;
  public TipoMaterial tipoMaterial;

  public Material(TipoMaterial tipoMaterial,Trama trama){
    this.trama = trama;
    this.tipoMaterial = tipoMaterial;
  }

  public Material(TipoMaterial tipoMaterial){
    this.tipoMaterial = tipoMaterial;
  } // 2 constructores, si no le pasamos nada por default la trama es lisa
}
