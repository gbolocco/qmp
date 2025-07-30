package org.example.domain.services.accuWeather;

import java.util.List;
import org.example.domain.services.accuWeather.entities.Clima;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AccuWeatherClimaAPI {
  //AccuWeatherAPI apiClima = new AccuWeatherAPI();
//  List<Map<String, Object>> condicionesClimaticas = apiClima.getWeather(“Buenos Aires, Argentina”);
//  condicionesClimaticas.get(0).get("PrecipitationProbability"); //Devuelve un número del 0 al 1

  @GET("forecasts/v1/hourly/1hour/{locationKey}")
  Call<List<Clima>> getClima(@Path("locationKey") String locationKey, @Query("apikey") String apiKey, @Query("metric") boolean metric);
}
