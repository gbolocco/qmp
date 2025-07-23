package org.example.domain.Guardarropa;

import java.util.ArrayList;
import java.util.List;
import org.example.domain.PropuestaModificacion.PropuestaAgregarPrenda;
import org.example.domain.PropuestaModificacion.PropuestaGuardarropa;
import org.example.domain.PropuestaModificacion.PropuestaRemoverPrenda;
import org.example.domain.Usuario;
import org.example.domain.prenda.Prenda;

public class Guardarropa {

  public String criterio;
  public List<Prenda> prendas;
  public Usuario propietario;
  public List<Usuario> colaboradores =  new ArrayList<Usuario>();
  public List<PropuestaGuardarropa> propuestas = new ArrayList<>();
  public List<PropuestaGuardarropa> propuestasAceptadas = new ArrayList<>();

  public Guardarropa(Usuario propietario, String criterio, List<Prenda> prendas) {
    this.criterio = criterio;
    this.propietario = propietario;
    this.prendas = prendas;
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


  public void addPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void removePrenda(Prenda prenda) {
    this.prendas.remove(prenda);
  }

  public List<PropuestaGuardarropa> getPropuestas(){
      return this.propuestas;
  }

  public void addPropuesta(PropuestaGuardarropa propuesta) {
    this.propuestas.add(propuesta);
  }

  public void removePropuesta(PropuestaGuardarropa propuesta) {
    this.propuestas.remove(propuesta);
  }

  public void aceptar(PropuestaGuardarropa propuesta) {
    propuesta.aceptar(this);
    this.removePropuesta(propuesta);
    this.propuestasAceptadas.add(propuesta);
  }

  public void rechazar(PropuestaGuardarropa propuesta) {
    propuesta.rechazar(this);
    this.removePropuesta(propuesta);
  }


  // unicamente si es propietario
  public boolean esPropietario(Usuario usuario) {
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

  public void proponerAgregar(Prenda prenda){
    this.propuestas.add(new PropuestaAgregarPrenda(prenda));
  };

  public void proponerRemover(Prenda prenda){
    this.propuestas.add(new PropuestaRemoverPrenda(prenda));
  };

}
