package org.example.domain.Guardarropa;

import java.util.ArrayList;
import java.util.List;
import org.example.domain.Usuario;

public class GuardarropasRepository {

  private static final GuardarropasRepository instance = new GuardarropasRepository();

  List<Guardarropa> guardarropas =  new ArrayList<>();

  private GuardarropasRepository() {}

  public static GuardarropasRepository getInstance() {
    return instance;
  }

  public void addGuardarropa(Guardarropa guardropa) {
    this.guardarropas.add(guardropa);
  }

  public List<Guardarropa> getGuardarropas(Usuario usuario) {
    return guardarropas.stream().filter(g -> g.tienePermisoLectura(usuario)).toList();
  }

}
