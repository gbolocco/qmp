package org.example.domain.sugerencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.example.domain.Guardarropa.Guardarropa;
import org.example.domain.usuario.Usuario;
import org.example.domain.prenda.Prenda;

public abstract class MotorSugerencias {

  public abstract List<Prenda> getPrendasValidas(Usuario usuario, Guardarropa guardarropa) throws IOException;

  public List<Sugerencia> generarSugerencias(Usuario usuario, Guardarropa guardarropa) throws IOException {

    List<Prenda> prendasValidas = this.getPrendasValidas(usuario, guardarropa);

    List<Sugerencia> sugerencias = new ArrayList<>();

    for (Prenda sup : prendasValidas.stream().filter(Prenda::esSuperior).toList()) {
      for (Prenda inf : prendasValidas.stream().filter(Prenda::esInferior).toList()) {
        for (Prenda calz : prendasValidas.stream().filter(Prenda::esCalzado).toList()) {
          sugerencias.add(new Sugerencia(sup,inf,null,calz));
        }
      }
    }

    return sugerencias;

  }



}
