package org.example.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.example.domain.Guardarropa.Guardarropa;
import org.example.domain.Guardarropa.GuardarropasRepository;
import org.example.domain.PropuestaModificacion.PropuestaGuardarropa;
import org.example.domain.prenda.Prenda;
import org.example.domain.sugerencia.MotorSugerencias;
import org.example.domain.sugerencia.Sugerencia;

public class Usuario {

  public Integer edad;
  public MotorSugerencias motorSugerencias;

  public Usuario(Integer edad, MotorSugerencias motor) {
    this.edad = edad;
    this.motorSugerencias = motor;
  }


  public void setMotor(MotorSugerencias motor) {
    this.motorSugerencias = motor;
  }


  public Integer getEdad() {
    return edad;
  }


  public List<Sugerencia> generarSugerencias(String criterio) throws Exception {
    Guardarropa guardarropa = this.getGuardarropaSegunCriterio(criterio);
    return this.motorSugerencias.generarSugerencias(this, guardarropa);
  }

  // TODO meter refactor aca, ver q onda con las validaciones y permisos

  public List<Guardarropa> getGuardarropas() {
    return GuardarropasRepository.getInstance().getGuardarropas().stream().filter(g -> g.tienePermisoLectura(this)).toList();
  }

  public Guardarropa getGuardarropaSegunCriterio(String criterio) {
    return this.getGuardarropas().stream()
        .filter(g -> g.getCriterio().equals(criterio))
        .findFirst()
        .orElseThrow(() -> new NoSuchElementException("No se encontró guardarropa con criterio: " + criterio));
  }

  public List<Guardarropa> getGuardarropasPropios() {
    return GuardarropasRepository.getInstance().getGuardarropas().stream().filter(g -> g.esPropietario(this)).toList();
  }

  public Guardarropa getGuardarropaPropioSegunCriterio(String criterio) {
    return this.getGuardarropasPropios().stream()
        .filter(g -> g.getCriterio().equals(criterio))
        .findFirst()
        .orElseThrow(() -> new NoSuchElementException("No se encontró guardarropa con criterio: " + criterio));
  }

//========================

  public List<PropuestaGuardarropa> getPropuestasGuardarropa(String criterio) throws Exception {
    Guardarropa guardarropa = this.getGuardarropaPropioSegunCriterio(criterio);
    return guardarropa.getPropuestas();
  }

  public void crearGuardarropa(String criterio, List<Prenda> prendas) {
    Guardarropa nuevoGuardarropa = new Guardarropa(this, criterio, prendas);
    GuardarropasRepository.getInstance().addGuardarropa(nuevoGuardarropa);
  }


  public void addPrenda(String criterio, Prenda prenda) throws Exception {
    Guardarropa guardarropa = this.getGuardarropaPropioSegunCriterio(criterio);
    guardarropa.addPrenda(prenda);
  }

  public void removePrenda(String criterio, Prenda prenda) throws Exception {
    Guardarropa guardarropa = this.getGuardarropaPropioSegunCriterio(criterio);
    guardarropa.removePrenda(prenda);
  }



  public void addColaborador(Usuario colaborador, String criterio) throws Exception {
    Guardarropa guardarropa = this.getGuardarropaPropioSegunCriterio(criterio);
    guardarropa.addColaborador(colaborador);
  }

  public void removeColaborador(Usuario colaborador, String criterio) throws Exception {
    Guardarropa guardarropa = this.getGuardarropaPropioSegunCriterio(criterio);
    guardarropa.removeColaborador(colaborador);
  }

}