package org.example.domain.sugerencia;

import org.example.domain.prenda.Prenda;

public class Sugerencia {

  public Prenda prendasSuperior;
  public Prenda prendasInferior;
  public Prenda accesorio;
  public Prenda calzado;

  public Sugerencia(Prenda prendasSuperior, Prenda prendasInferior,  Prenda accesorio, Prenda calzado) {
    this.prendasSuperior = prendasSuperior;
    this.prendasInferior = prendasInferior;
    this.accesorio = accesorio;
    this.calzado = calzado;
  }
}
