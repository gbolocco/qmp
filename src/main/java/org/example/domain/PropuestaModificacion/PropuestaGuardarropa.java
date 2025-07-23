package org.example.domain.PropuestaModificacion;

import org.example.domain.Guardarropa.Guardarropa;
import org.example.domain.prenda.Prenda;

public abstract class PropuestaGuardarropa {

  public Prenda prenda;
  public String criterio;

  public PropuestaGuardarropa(Prenda prenda) {
    this.prenda = prenda;
  }

  public abstract void aceptar(Guardarropa guardarropa);

  public abstract void rechazar(Guardarropa guardarropa);

}
