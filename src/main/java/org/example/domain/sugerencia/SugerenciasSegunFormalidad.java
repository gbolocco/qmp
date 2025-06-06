package org.example.domain.sugerencia;

import java.util.ArrayList;
import java.util.List;
import org.example.domain.Usuario;
import org.example.domain.prenda.Prenda;

public class SugerenciasSegunFormalidad implements MotorSugerencias {


  private List<Prenda> prendasValidas(Usuario usuario){

    if (usuario.getEdad() > 55) {

      return usuario.getGuardarropa().stream()
          .filter(Prenda::esFormal)
          .toList();

    } else {
      return usuario.getGuardarropa();
    }
  }

  public List<Sugerencia> generarSugerencias(Usuario usuario) {

    List<Prenda> prendasValidas = prendasValidas(usuario);

    List<Sugerencia> sugerencias = new ArrayList<>();

    for (Prenda sup : prendasValidas.stream().filter(Prenda::esSuperior).toList()) {
      for (Prenda inf : prendasValidas.stream().filter(Prenda::esInferior).toList()) {
        for (Prenda calz : prendasValidas.stream().filter(Prenda::esCalzado).toList()) {
          sugerencias.add(new Sugerencia(sup,inf,null,calz));
        }
      }
    }

    return sugerencias;
  };
}
