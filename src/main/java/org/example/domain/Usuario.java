package org.example.domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.example.domain.prenda.Prenda;
import org.example.domain.sugerencia.MotorSugerencias;
import org.example.domain.sugerencia.Sugerencia;

public class Usuario {

  public List<Guardarropa> guardarropas;
  public Integer edad;
  public MotorSugerencias motorSugerencias;

  public Usuario(List<Guardarropa> guardarropas, Integer edad, MotorSugerencias motor) {
    this.edad = edad;
    this.guardarropas = guardarropas;
    this.motorSugerencias = motor;
  }

  public void setMotor(MotorSugerencias motor) {
    this.motorSugerencias = motor;
  }


  public Integer getEdad() {
    return edad;
  }


  public List<Sugerencia> generarSugerencias(String criterio) throws IOException {
    Guardarropa guardarropa = this.getGuardarropa(criterio);
    return this.motorSugerencias.generarSugerencias(this, guardarropa);
  }

  public List<Guardarropa> getGuardarropas() {
    return this.guardarropas;
  }

  public Guardarropa getGuardarropa(String criterio) {
    return this.guardarropas.stream()
        .filter(g -> g.getCriterio().equals(criterio))
        .findFirst()
        .orElseThrow(() -> new NoSuchElementException("No se encontró guardarropa con criterio: " + criterio));
  }

  public void addGuardarropa(Guardarropa guardarropa) {
    this.guardarropas.add(guardarropa);
  }

}