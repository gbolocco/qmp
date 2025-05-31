package org.example;

import java.util.List;
import java.util.stream.Collectors;
import org.example.prenda.Prenda;
import org.example.prenda.Tipo;
import org.example.sugerencia.MotorSugerencias;
import org.example.sugerencia.Sugerencia;

public class Usuario {

  public List<Prenda> guardarropa;
  public Integer edad;
  public MotorSugerencias motorSugerencias;

  public Usuario(List<Prenda> guardarropa,  Integer edad, MotorSugerencias motor) {
    this.guardarropa = guardarropa;
    this.edad = edad;
    this.motorSugerencias = motor;
  }

  public void setMotor(MotorSugerencias motor) {
    this.motorSugerencias = motor;
  }


  public Integer getEdad() {
    return edad;
  }

  public List<Prenda> getGuardarropa() {
    return guardarropa;
  }

  public List<Sugerencia> generarSugerencias(){
    return this.motorSugerencias.generarSugerencias(this);
  }
}