package org.example.sugerencia;

public class ProveedorDeMotor {

  private static final ProveedorDeMotor INSTANCE = new ProveedorDeMotor();

  private MotorSugerencias motor;

  private ProveedorDeMotor() {
    // Constructor privado para evitar instanciación externa
  }

  public static ProveedorDeMotor getInstance() {
    return INSTANCE;
  }

  public MotorSugerencias getMotor() {
    return motor;
  }

  public void setMotor(MotorSugerencias motor) {
    this.motor = motor;
  }
}

//Usuario pepe = new Usuario(29, ProveedorMotor.getMotor())

//  Cuando lo quiero cambiar, lo cambio para todos los usuarios con el setter

//  ProveedorMotor.setMotor(new OtroMotor(...))
//  List<Usuario> todosLosUsuarios = ... //De dónde saldría esto? A pensar! ;) Ya lo veremos...
//  todosLosUsuarios.forEach(u -> u.setMotor(ProveedorMotor.getMotor()))