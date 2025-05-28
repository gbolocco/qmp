package org.example.uniformesBonusQMP2;

import java.util.List;
import org.example.Prenda;
import org.example.atuendos.Atuendo;

public class Uniforme extends Atuendo {

  public Institucion institucion;

  public Uniforme(List<Prenda> prendas, Institucion institucion) {
    super(prendas);
    this.institucion = institucion;
    this.validarUniforme(prendas);
  }

  public void validarUniforme(List<Prenda> prendas) {
    if(
        prendas.stream().noneMatch(prenda -> prenda.getTipo().getCategoria() == Prenda.Tipo.Categoria.CALZADO)
        || prendas.stream().noneMatch(prenda -> prenda.getTipo().getCategoria() == Prenda.Tipo.Categoria.PARTE_SUPERIOR)
        || prendas.stream().noneMatch(prenda -> prenda.getTipo().getCategoria() == Prenda.Tipo.Categoria.PARTE_INFERIOR)
    ){
      throw new IllegalArgumentException("El uniforme debe tener calzado, parte superior y parte inferior");
    }
    this.institucion.validarUniforme(prendas);
  }
}
