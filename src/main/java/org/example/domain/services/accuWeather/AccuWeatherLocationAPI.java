package org.example.domain.services.accuWeather;

import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AccuWeatherLocationAPI {

  @GET("locations/v1/cities/search")
  Call<List<Map<String, Object>>> buscarCiudad(@Query("apikey") String apiKey, @Query("q") String ciudad);
}
