package org.example;

import java.io.IOException;
import org.example.domain.services.accuWeather.AccuWeatherService;
import org.example.domain.services.accuWeather.entities.Clima;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QMP4Tests {
  Clima clima;

  public QMP4Tests() throws IOException {
    clima = AccuWeatherService.getInstance().obtenerClima();
  }

  @Test
  void prueboApi() {
    System.out.println("Temperatura: " + clima.temperature.value + "°" + clima.temperature.unit);
    System.out.println("Descripción: " + clima.iconPhrase);
    Assertions.assertNotNull(clima);
  }
}
