package org.example.domain.PropuestaModificacion;

import org.example.domain.Guardarropa.Guardarropa;
import org.example.domain.prenda.Prenda;

public class PropuestaRemoverPrenda extends PropuestaGuardarropa {

  public PropuestaRemoverPrenda(Prenda prenda) {
    super(prenda);
  }

  public void aceptar(Guardarropa guardarropa){
    guardarropa.removePrenda(prenda);
  }

  public void rechazar(Guardarropa guardarropa){}

  public void deshacer(Guardarropa guardarropa){
    guardarropa.addPrenda(prenda);
  }
}