package org.example.domain.services.accuWeather;

import java.util.List;
import java.util.Map;
import org.example.domain.services.accuWeather.entities.Clima;
import retrofit2.Call;
import retrofit2.http.GET;

public interface AccuWeatherAPI {
  //AccuWeatherAPI apiClima = new AccuWeatherAPI();
//  List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(“Buenos Aires, Argentina”);
//  condicionesClimaticas.get(0).get("PrecipitationProbability"); //Devuelve un número del 0 al 1

  @GET("7894?apikey=SVEWQm33aXnRv1ycR52Lmy0cv5dxJkuq&metric=true")
  Call<List<Clima>> getClima();
}
