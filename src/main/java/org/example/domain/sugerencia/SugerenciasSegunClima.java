package org.example.domain.sugerencia;

import java.io.IOException;
import java.util.List;
import org.example.domain.Guardarropa.Guardarropa;
import org.example.domain.Usuario;
import org.example.domain.prenda.Prenda;
import org.example.domain.services.accuWeather.AccuWeatherService;
import org.example.domain.services.accuWeather.entities.Clima;

public class SugerenciasSegunClima extends MotorSugerencias {

  private final AccuWeatherService accuWeatherService;

  public SugerenciasSegunClima(AccuWeatherService accuWeatherService) {
    this.accuWeatherService = accuWeatherService;
  }

  public List<Prenda> getPrendasValidas(Usuario usuario, Guardarropa guardarropa) throws IOException {

    Clima climaActual = accuWeatherService.obtenerClima();

    List<Prenda> prendas = guardarropa.getPrendas();

    if (climaActual.hasPrecipitation) {
      prendas = prendas.stream().filter(Prenda::esImpermeable).toList();
    } else if (climaActual.temperature.value > 15) {
      prendas = prendas.stream().filter(p -> p.getIndiceAbrigo() <= 3).toList();
    } else if (climaActual.temperature.value <= 15 && climaActual.temperature.value > 5) {
      prendas =  prendas.stream().filter(p -> p.getIndiceAbrigo() > 3).toList();
    } else {
      prendas =  prendas.stream().filter(p -> p.getIndiceAbrigo() >= 7).toList();
    }

    return prendas;

  }
}
