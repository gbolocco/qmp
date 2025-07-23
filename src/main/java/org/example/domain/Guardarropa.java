package org.example.domain;

import java.util.List;
import org.example.domain.prenda.Prenda;

public class Guardarropa {

  public String criterio;
  public List<Prenda> prendas;

  public Guardarropa(String criterio, List<Prenda> prendas) {
    this.criterio = criterio;
    this.prendas = prendas;
  }

  public void addPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void removePrenda(Prenda prenda) {
    this.prendas.remove(prenda);
  }

  public String getCriterio() {
    return criterio;
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }


}
