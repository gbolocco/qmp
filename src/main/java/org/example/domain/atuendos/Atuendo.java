package org.example.domain.atuendos;

import java.util.List;
import org.example.domain.prenda.Prenda;

public class Atuendo {

  public List<Prenda> prendas;

  public Atuendo(List<Prenda> prendas){
    this.prendas = prendas;
  }

  public void addPrenda(Prenda unaPrenda) {
    this.prendas.add(unaPrenda);
  }
}
