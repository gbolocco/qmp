package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;
import org.example.domain.Guardarropa.Guardarropa;
import org.example.domain.usuario.Usuario;
import org.example.domain.borrador.Borrador;
import org.example.domain.prenda.Material;
import org.example.domain.prenda.Prenda;
import org.example.domain.prenda.Tipo;
import org.example.domain.services.accuWeather.AccuWeatherService;
import org.example.domain.services.accuWeather.entities.Clima;
import org.example.domain.services.accuWeather.entities.Temperature;
import org.example.domain.sugerencia.MotorSugerencias;
import org.example.domain.sugerencia.Sugerencia;
import org.example.domain.sugerencia.SugerenciasSegunClima;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QMP4Tests {

  private AccuWeatherService mockServiceCalor;
  private AccuWeatherService mockServiceFrio;
  private AccuWeatherService mockServiceLluvioso;
  private MotorSugerencias motorCalor;
  private MotorSugerencias motorFrio;
  private MotorSugerencias motorLluvioso;
  private Usuario usuario;
  private Guardarropa guardarropa;


  @BeforeEach
  void setup() throws IOException {

    // Crear mock del servicio
    mockServiceCalor = mock(AccuWeatherService.class);
    mockServiceFrio = mock(AccuWeatherService.class);
    mockServiceLluvioso = mock(AccuWeatherService.class);

    // Stub para el clima
    Clima climaFrio = new Clima();
    climaFrio.hasPrecipitation = false;
    climaFrio.temperature = new Temperature();
    climaFrio.temperature.value = 1;

    Clima climaCalor= new Clima();
    climaCalor.hasPrecipitation = false;
    climaCalor.temperature = new Temperature();
    climaCalor.temperature.value = 20;

    Clima climaLluvioso= new Clima();
    climaLluvioso.hasPrecipitation = true;
    climaLluvioso.temperature = new Temperature();
    climaLluvioso.temperature.value = 20;



    when(mockServiceCalor.obtenerClima("test")).thenReturn(climaCalor);
    when(mockServiceFrio.obtenerClima("test")).thenReturn(climaFrio);
    when(mockServiceLluvioso.obtenerClima("test")).thenReturn(climaLluvioso);

    // Motor sugerencias
    motorCalor= new SugerenciasSegunClima(mockServiceCalor);
    motorFrio = new SugerenciasSegunClima(mockServiceFrio);
    motorLluvioso = new SugerenciasSegunClima(mockServiceLluvioso);


    Borrador borradorParteInfFrio = new Borrador(Tipo.PANTALON, mock(Material.class));
    borradorParteInfFrio.setImpermeable(false);
    borradorParteInfFrio.setIndiceAbrigo(8);
    Prenda parteInfFrio = borradorParteInfFrio.crearPrenda();

    Borrador borradorParteInfCalor = new Borrador(Tipo.PANTALON, mock(Material.class));
    borradorParteInfCalor.setImpermeable(false);
    borradorParteInfCalor.setIndiceAbrigo(2);
    Prenda parteInfCalor = borradorParteInfFrio.crearPrenda();

    Borrador borradorCalzadoFrio =  new Borrador(Tipo.ZAPATO, mock(Material.class));
    borradorCalzadoFrio.setImpermeable(false);
    borradorCalzadoFrio.setIndiceAbrigo(8);
    Prenda calzadoFrio = borradorCalzadoFrio.crearPrenda();

    Borrador borradorCalzadoCalor = new Borrador(Tipo.ZAPATO, mock(Material.class));
    borradorCalzadoCalor.setImpermeable(false);
    borradorCalzadoCalor.setIndiceAbrigo(2);
    Prenda calzadoCalor = borradorCalzadoCalor.crearPrenda();

    Borrador borradorParteSupCalor = new Borrador(Tipo.CHOMBA, mock(Material.class));
    borradorParteSupCalor.setImpermeable(false);
    borradorParteSupCalor.setIndiceAbrigo(2);
    Prenda parteSupCalor = borradorParteSupCalor.crearPrenda();

    Borrador borradorParteSupFrio = new Borrador(Tipo.BUZO, mock(Material.class));
    borradorParteSupFrio.setImpermeable(false);
    borradorParteSupFrio.setIndiceAbrigo(8);
    Prenda parteSupFrio = borradorParteSupFrio.crearPrenda();

    usuario = new Usuario(30,mock(MotorSugerencias.class), "test");
    usuario.crearGuardarropa("test", List.of(parteInfFrio, parteInfCalor, calzadoFrio, calzadoCalor, parteSupCalor, parteSupFrio));

  }


  @Test
  void filtraPrendasValidasSegunClimaCaluroso() throws IOException {
    assertFalse(motorCalor.getPrendasValidas(usuario,usuario.getGuardarropaSegunCriterio("test")).isEmpty());
  }

  @Test
  void noObtienePrendasValidasPorqueElUsuarioNoTienePrendasImpermeable() throws IOException {
    assertTrue(motorLluvioso.getPrendasValidas(usuario,usuario.getGuardarropaSegunCriterio("test")).isEmpty());
  }

  @Test
  void seGeneranSugerenciasSegunClima() throws Exception {
    usuario.setMotor(motorFrio);
    List<Sugerencia> sugerencias = usuario.generarSugerencias("test");
    assertFalse(sugerencias.isEmpty());
  }

////// este test funciona, solo que le pega a la api real
//  @Test
//  void climaActual() throws IOException {
//
//    Clima clima = AccuWeatherService.getInstance().obtenerClima("Ushuaia");
//    System.out.println("Temperatura: " + clima.temperature.value + "°" + clima.temperature.unit);
//    System.out.println("Descripción: " + clima.iconPhrase);
//    System.out.println("Esta lloviendo: " + clima.hasPrecipitation);
//    System.out.println("Probabilidad de lluvia: " + clima.precipitationProbability);
//    assertNotNull(clima);
//  }

}