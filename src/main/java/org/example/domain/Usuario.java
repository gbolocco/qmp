package org.example.domain;

import java.util.List;
import java.util.NoSuchElementException;
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

  public void validarPermisoEscritura(Guardarropa guardarropa) throws Exception {
    if (!guardarropa.tienePermisoEscritura(this)) {
      throw new Exception("No tiene permisos para ejecutar accion");
    }
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

  public List<Guardarropa> getGuardarropas() {
    return GuardarropasRepository.getInstance().getGuardarropas(this);
  }

  public Guardarropa getGuardarropaSegunCriterio(String criterio) {
    return this.getGuardarropas().stream()
        .filter(g -> g.getCriterio().equals(criterio))
        .findFirst()
        .orElseThrow(() -> new NoSuchElementException("No se encontró guardarropa con criterio: " + criterio));
  }

  public void crearGuardarropa(String criterio, List<Prenda> prendas) {
    Guardarropa nuevoGuardarropa = new Guardarropa(this, criterio, prendas);
    GuardarropasRepository.getInstance().addGuardarropa(nuevoGuardarropa);
  }


  public void addPrenda(String criterio, Prenda prenda) throws Exception {
    Guardarropa guardarropa = this.getGuardarropaSegunCriterio(criterio);
    validarPermisoEscritura(guardarropa);
    guardarropa.addPrenda(prenda);
  }

  public void removePrenda(String criterio, Prenda prenda) throws Exception {
    Guardarropa guardarropa = this.getGuardarropaSegunCriterio(criterio);
    validarPermisoEscritura(guardarropa);
    guardarropa.removePrenda(prenda);
  }


  public void realizarPropuestaModificacion(PropuestaGuardarropa propuesta) {

  }


  public void addColaborador(Usuario colaborador, String criterio) throws Exception {
    Guardarropa guardarropa = this.getGuardarropaSegunCriterio(criterio);
    validarPermisoEscritura(guardarropa);
    guardarropa.addColaborador(colaborador);
  }

  public void removeColaborador(Usuario colaborador, String criterio) throws Exception {
    Guardarropa guardarropa = this.getGuardarropaSegunCriterio(criterio);
    validarPermisoEscritura(guardarropa);
    guardarropa.removeColaborador(colaborador);
  }

}