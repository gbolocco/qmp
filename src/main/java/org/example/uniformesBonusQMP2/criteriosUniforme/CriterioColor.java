package org.example.uniformesBonusQMP2.criteriosUniforme;

import org.example.Prenda;

public class CriterioColor extends CriterioUniforme {

  public Prenda.Color color;

  public CriterioColor(Prenda.Tipo tipo, Prenda.Color color){
    super(tipo);
    this.color = color;
  }

  public boolean validar(Prenda prenda){
    return prenda.getTipo().getCategoria() == tipo.getCategoria() && prenda.getColorPrimario() == color;
  }
}
