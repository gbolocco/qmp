package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.example.domain.Usuario;
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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class QMP4Tests {

  private AccuWeatherService mockService;
  private MotorSugerencias motor;
  private List<Prenda> guardarropa;
  private Prenda prenda;


  @BeforeEach
  void setup() throws IOException {
    // Crear mock del servicio
    mockService = mock(AccuWeatherService.class);

    // Stub para el clima
    Clima clima = new Clima();
    clima.hasPrecipitation = false;
    clima.temperature = new Temperature();
    clima.temperature.value = 14;

    when(mockService.obtenerClima()).thenReturn(clima);

    // Motor sugerencias
    motor = new SugerenciasSegunClima(mockService);

    Prenda parteSupCalor = mock(Prenda.class);
    when(parteSupCalor.getTipo()).thenReturn(Tipo.CAMISA);
    when(parteSupCalor.getIndiceAbrigo()).thenReturn(2);
    when(parteSupCalor.esImpermeable()).thenReturn(false);

    Prenda parteSupFrio = mock(Prenda.class);
    when(parteSupFrio.getTipo()).thenReturn(Tipo.CAMISA);
    when(parteSupFrio.getIndiceAbrigo()).thenReturn(8);
    when(parteSupFrio.esImpermeable()).thenReturn(true);

    Prenda parteInfFrio = mock(Prenda.class);
    when(parteInfFrio.getTipo()).thenReturn(Tipo.PANTALON);
    when(parteInfFrio.getIndiceAbrigo()).thenReturn(8);
    when(parteInfFrio.esImpermeable()).thenReturn(true);


    Prenda parteInfCalor = mock(Prenda.class);
    when(parteInfCalor.getTipo()).thenReturn(Tipo.PANTALON);
    when(parteInfCalor.getIndiceAbrigo()).thenReturn(2);
    when(parteInfCalor.esImpermeable()).thenReturn(false);

    Prenda calzadoFrio = mock(Prenda.class);
    when(calzadoFrio.getTipo()).thenReturn(Tipo.ZAPATO);
    when(calzadoFrio.getIndiceAbrigo()).thenReturn(8);
    when(calzadoFrio.esImpermeable()).thenReturn(true);

    Prenda calzadoCalor = mock(Prenda.class);
    when(calzadoCalor.getTipo()).thenReturn(Tipo.ZAPATO);
    when(calzadoCalor.getIndiceAbrigo()).thenReturn(2);
    when(calzadoCalor.esImpermeable()).thenReturn(false);

    guardarropa = List.of(parteInfFrio, parteInfCalor, calzadoFrio, calzadoCalor, parteSupCalor, parteSupFrio);
  }

  @Test
  void seGeneranSugerenciasSegunClima() throws IOException {
    Usuario usuario = new Usuario(guardarropa, 30, motor);
    List<Sugerencia> sugerencias = usuario.generarSugerencias();
    Assertions.assertFalse(sugerencias.isEmpty());
//    System.out.println(motor.getPrendasValidas(usuario).size());
//    assertFalse(motor.getPrendasValidas(usuario).isEmpty());
  }

//  @Test
//  void climaActual() throws IOException {
//    Clima clima = AccuWeatherService.getInstance().obtenerClima();
//    System.out.println("Temperatura: " + clima.temperature.value + "°" + clima.temperature.unit);
//    System.out.println("Descripción: " + clima.iconPhrase);
//    System.out.println("Esta lloviendo: " + clima.hasPrecipitation);
//    System.out.println("Probabilidad de lluvia: " + clima.precipitationProbability);
//    Assertions.assertNotNull(clima);
//  }

}