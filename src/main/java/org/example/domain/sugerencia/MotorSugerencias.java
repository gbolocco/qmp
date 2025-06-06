package org.example.domain.sugerencia;

import java.util.List;
import org.example.domain.Usuario;

public interface MotorSugerencias {

  public List<Sugerencia> generarSugerencias(Usuario usuario);
}
