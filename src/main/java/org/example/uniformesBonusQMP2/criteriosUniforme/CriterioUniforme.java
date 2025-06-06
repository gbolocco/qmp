package org.example.uniformesBonusQMP2.criteriosUniforme;

import org.example.domain.prenda.Prenda;
import org.example.domain.prenda.Tipo;

public abstract class CriterioUniforme {

  public Tipo tipo;

  public CriterioUniforme(Tipo tipo){
    this.tipo = tipo;
  }

  public abstract boolean validar(Prenda prenda);
}
