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

  public void addGuardarropa(Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }

  public List<Guardarropa> getGuardarropas() {
    return guardarropas;
  }

}
