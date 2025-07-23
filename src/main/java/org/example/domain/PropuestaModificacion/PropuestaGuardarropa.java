package org.example.domain.PropuestaModificacion;

import org.example.domain.Usuario;
import org.example.domain.prenda.Prenda;

public abstract class PropuestaGuardarropa {

  public Prenda prenda;
  public Usuario destinatario;
  public String criterio;

  public abstract void aceptar();

  public abstract void rechazar();

}
