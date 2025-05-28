package org.example.uniformesBonusQMP2.criteriosUniforme;

import org.example.Prenda;

public abstract class CriterioUniforme {

  public Prenda.Tipo tipo;

  public CriterioUniforme(Prenda.Tipo tipo){
    this.tipo = tipo;
  }

  public abstract boolean validar(Prenda prenda);
}
