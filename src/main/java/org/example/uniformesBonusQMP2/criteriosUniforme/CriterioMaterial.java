package org.example.uniformesBonusQMP2.criteriosUniforme;

import org.example.Prenda;
import org.example.Material;

public class CriterioMaterial extends CriterioUniforme {

  Material.TipoMaterial material;

 public CriterioMaterial(Prenda.Tipo tipo, Material.TipoMaterial material){
   super(tipo);
   this.material = material;
 }

 public boolean validar(Prenda prenda){
   return prenda.getTipo().getCategoria() == tipo.getCategoria() && prenda.getMaterial() == material;
 }

}
