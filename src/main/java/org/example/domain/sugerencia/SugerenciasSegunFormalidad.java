package org.example.domain.sugerencia;

import java.util.List;
import org.example.domain.Usuario;
import org.example.domain.prenda.Prenda;

public class SugerenciasSegunFormalidad extends MotorSugerencias {


  public List<Prenda> getPrendasValidas(Usuario usuario){

    if (usuario.getEdad() > 55) {

      return usuario.getGuardarropa().stream()
          .filter(Prenda::esFormal)
          .toList();

    } else {
      return usuario.getGuardarropa();
    }
  }

}
