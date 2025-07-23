package org.example.domain.Guardarropa;

import java.util.ArrayList;
import java.util.List;
import org.example.domain.Usuario;
import org.example.domain.prenda.Prenda;

public class Guardarropa {

  public String criterio;
  public List<Prenda> prendas;
  public Usuario propietario;
  public List<Usuario> colaboradores =  new ArrayList<Usuario>();

  public Guardarropa(Usuario propietario, String criterio, List<Prenda> prendas) {
    this.criterio = criterio;
    this.propietario = propietario;
    this.prendas = prendas;
  }

  public void addPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void removePrenda(Prenda prenda) {
    this.prendas.remove(prenda);
  }

  public List<Usuario> getColaboradores() {
    return this.colaboradores;
  }

  public String getCriterio() {
    return criterio;
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }


  // unicamente si es propietario
  public boolean tienePermisoEscritura(Usuario usuario) {
    return this.propietario.equals(usuario);
  }

  // si es contribuyente o propietario
  public boolean tienePermisoLectura(Usuario usuario) {
    return (this.propietario.equals(usuario) || this.colaboradores.contains(usuario));
  }


  public void addColaborador(Usuario colaborador) {
    this.colaboradores.add(colaborador);
  }

  public void removeColaborador(Usuario colaborador) {
    this.colaboradores.remove(colaborador);
  }

}
