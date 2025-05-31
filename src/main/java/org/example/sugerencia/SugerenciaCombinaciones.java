package org.example.sugerencia;

import java.util.ArrayList;
import java.util.List;
import org.example.Usuario;
import org.example.prenda.Prenda;
import org.example.prenda.Tipo;

public class SugerenciaCombinaciones implements MotorSugerencias {

  public List<Sugerencia> generarSugerencias(Usuario usuario) {

    List<Sugerencia> sugerencias = new ArrayList<>();

    for (Prenda sup : usuario.getGuardarropa().stream().filter(Prenda::esSuperior).toList()) {
      for (Prenda inf : usuario.getGuardarropa().stream().filter(Prenda::esInferior).toList()) {
        for (Prenda calz : usuario.getGuardarropa().stream().filter(Prenda::esCalzado).toList()) {
          sugerencias.add(new Sugerencia(sup,inf,null,calz));
        }
      }
    }

    return sugerencias;
  }
}
