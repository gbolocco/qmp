package org.example.uniformesBonusQMP2;

import java.util.List;
import org.example.domain.prenda.Prenda;
import org.example.domain.atuendos.Atuendo;
import org.example.domain.prenda.Tipo;

public class Uniforme extends Atuendo {

  public Institucion institucion = null;

  public Uniforme(List<Prenda> prendas, Institucion institucion) {
    super(prendas);
    this.institucion = institucion;
    this.validarUniforme(prendas);
  }

  public Uniforme(List<Prenda> prendas) {
    super(prendas);
    this.validarUniforme(prendas);
  }

  public void validarUniforme(List<Prenda> prendas) {
    if(
        prendas.stream().noneMatch(prenda -> prenda.getTipo().getCategoria() == Tipo.Categoria.CALZADO)
        || prendas.stream().noneMatch(prenda -> prenda.getTipo().getCategoria() == Tipo.Categoria.PARTE_SUPERIOR)
        || prendas.stream().noneMatch(prenda -> prenda.getTipo().getCategoria() == Tipo.Categoria.PARTE_INFERIOR)
    ){
      throw new IllegalArgumentException("El uniforme debe tener calzado, parte superior y parte inferior");
    } else if (institucion != null) {

      this.institucion.validarUniforme(prendas);
    }
  }
}
