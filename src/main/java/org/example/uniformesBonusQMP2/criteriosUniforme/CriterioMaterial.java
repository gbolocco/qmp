package org.example.uniformesBonusQMP2.criteriosUniforme;

import org.example.prenda.Prenda;
import org.example.prenda.Material;
import org.example.prenda.Tipo;

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
