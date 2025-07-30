package org.example.domain.usuario;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import org.example.domain.Guardarropa.Guardarropa;
import org.example.domain.Guardarropa.GuardarropasRepository;
import org.example.domain.PropuestaModificacion.PropuestaGuardarropa;
import org.example.domain.alerta.AlertaMeteorologica;
import org.example.domain.prenda.Prenda;
import org.example.domain.services.accuWeather.AccuWeatherService;
import org.example.domain.services.accuWeather.entities.Clima;
import org.example.domain.sugerencia.MotorSugerencias;
import org.example.domain.sugerencia.Sugerencia;

public class Usuario {

  public Integer edad;
  public MotorSugerencias motorSugerencias;
  public String ubicacion;

  public List<Sugerencia> sugerenciasDiarias;

  public Usuario(Integer edad, MotorSugerencias motor, String ubicacion) {
    this.edad = edad;
    this.ubicacion = ubicacion;
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

  public Guardarropa getGuardarropaRandom() {
    return this.getGuardarropas().stream().findAny().orElseThrow(() -> new NoSuchElementException("No posee guardarropas"));
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

  // =======================================


  public String getUbicacion() {
    return ubicacion;
  }

  public Clima getClimaActual(AccuWeatherService service) throws IOException {
    return service.obtenerClima(this.getUbicacion());
  }

  public void generarSugerenciasDiarias() throws Exception {
     this.sugerenciasDiarias = this.generarSugerencias(this.getGuardarropaRandom().getCriterio());
  }

  public List<AlertaMeteorologica> getAlertas(AccuWeatherService service) throws IOException {
    return service.obtenerAlertas(this.getUbicacion());
  }

}