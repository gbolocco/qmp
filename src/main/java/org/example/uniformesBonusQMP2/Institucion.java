package org.example.uniformesBonusQMP2;

import java.util.List;
import org.example.domain.prenda.Prenda;
import org.example.uniformesBonusQMP2.criteriosUniforme.CriterioUniforme;

public class Institucion {

  public List<CriterioUniforme> criterios;

  public Institucion(List<CriterioUniforme> criterios){
    this.criterios = criterios;
  }

  public void validarUniforme(List<Prenda> prendas){
    prendas.forEach(prenda -> {
       if(criterios.stream().noneMatch(criterio -> criterio.validar(prenda))){
         throw new IllegalArgumentException("La prenda no cumple con los criterios de la institucion");
       }
     });
  }

}
