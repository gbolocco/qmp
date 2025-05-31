package org.example.sugerencia;

import java.util.List;
import org.example.Usuario;

public interface MotorSugerencias {

  public List<Sugerencia> generarSugerencias(Usuario usuario);
}
