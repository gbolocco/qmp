package org.example.domain.sugerencia;

import java.util.ArrayList;
import java.util.List;
import org.example.domain.Usuario;
import org.example.domain.prenda.Prenda;

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
