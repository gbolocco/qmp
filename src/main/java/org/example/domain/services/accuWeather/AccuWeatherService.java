package org.example.domain.services.accuWeather;

import java.io.IOException;
import java.util.List;
import org.example.domain.services.accuWeather.entities.Clima;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class AccuWeatherService {

  private static final String url = "http://dataservice.accuweather.com/forecasts/v1/hourly/1hour/";

  private static AccuWeatherService instance = null;

  public static AccuWeatherService getInstance() {
    if (instance == null) {
      instance = new AccuWeatherService();
    }
    return instance;
  }

  private Retrofit retrofit;



  private AccuWeatherService() {
    this.retrofit = new Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }

  public Clima obtenerClima() throws IOException {
    AccuWeatherAPI api = retrofit.create(AccuWeatherAPI.class);
    Call<List<Clima>> call = api.getClima();
    Response<List<Clima>> response = call.execute();

    if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
      return response.body().get(0); // devuelve solo el primer resultado
    } else {
      throw new IOException("Error al obtener clima: " + response.code());
    }
  }
}