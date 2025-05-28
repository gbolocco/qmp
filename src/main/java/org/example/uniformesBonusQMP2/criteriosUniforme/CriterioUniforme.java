package org.example.uniformesBonusQMP2.criteriosUniforme;

import org.example.prenda.Prenda;
import org.example.prenda.Tipo;

public abstract class CriterioUniforme {

  public Tipo tipo;

  public CriterioUniforme(Tipo tipo){
    this.tipo = tipo;
  }

  public abstract boolean validar(Prenda prenda);
}
