package org.example.uniformesBonusQMP2.criteriosUniforme;

import org.example.domain.prenda.Color;
import org.example.domain.prenda.Prenda;
import org.example.domain.prenda.Tipo;

public class CriterioColor extends CriterioUniforme {

  public Color color;

  public CriterioColor(Tipo tipo, Color color){
    super(tipo);
    this.color = color;
  }

  public boolean validar(Prenda prenda){
    return prenda.getTipo().getCategoria() == tipo.getCategoria() && prenda.getColorPrimario() == color;
  }
}
