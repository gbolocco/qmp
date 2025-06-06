package org.example.uniformesBonusQMP2.criteriosUniforme;

import org.example.domain.prenda.Prenda;
import org.example.domain.prenda.Material;
import org.example.domain.prenda.Tipo;

public class CriterioMaterial extends CriterioUniforme {

  Material.TipoMaterial material;

 public CriterioMaterial(Tipo tipo, Material.TipoMaterial material){
   super(tipo);
   this.material = material;
 }

 public boolean validar(Prenda prenda){
   return prenda.getTipo().getCategoria() == tipo.getCategoria() && prenda.getMaterial() == material;
 }

}
