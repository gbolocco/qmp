package org.example.domain.sugerencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.example.domain.Usuario;
import org.example.domain.prenda.Prenda;

public abstract class MotorSugerencias {

  public List<Prenda> getPrendasValidas(Usuario usuario) throws IOException {
    return usuario.getGuardarropa();
  }

  public List<Sugerencia> generarSugerencias(Usuario usuario) throws IOException {

    List<Prenda> prendasValidas = this.getPrendasValidas(usuario);

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
