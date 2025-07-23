package org.example.domain.sugerencia;

import java.util.List;
import org.example.domain.Guardarropa.Guardarropa;
import org.example.domain.Usuario;
import org.example.domain.prenda.Prenda;

public class SugerenciaCombinaciones extends MotorSugerencias {

  public List<Prenda> getPrendasValidas(Usuario usuario, Guardarropa guardarropa) {
    return guardarropa.getPrendas();
  }
}
