package org.example.domain.services.accuWeather;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.example.domain.services.accuWeather.entities.Clima;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
Retrofit no permite cambiar dinámicamente la URL completa, así que lo más limpio es crear dos endpoints distintos:
*/

public class AccuWeatherService {

  private static final String API_KEY = "SVEWQm33aXnRv1ycR52Lmy0cv5dxJkuq";
  private static final String BASE_URL = "https://dataservice.accuweather.com/";


  private static AccuWeatherService instance = null;

  public static AccuWeatherService getInstance() {
    if (instance == null) {
      instance = new AccuWeatherService();
    }
    return instance;
  }

  private Retrofit retrofit;
  private final AccuWeatherLocationAPI locationAPI;
  private final AccuWeatherClimaAPI climaAPI;



  private AccuWeatherService() {
    this.retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    this.locationAPI = retrofit.create(AccuWeatherLocationAPI.class);
    this.climaAPI = retrofit.create(AccuWeatherClimaAPI.class);
  }



  public Clima obtenerClima(String ciudad) throws IOException {

    String locationKey = buscarLocationKey(ciudad);
    if (locationKey == null) {
      throw new IOException("No se encontró locationKey para ciudad: " + ciudad);
    }


    Call<List<Clima>> call = climaAPI.getClima(locationKey, API_KEY, true);
    Response<List<Clima>> response = call.execute();

    if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
      return response.body().get(0);
    } else {
      throw new IOException("Error al obtener clima: " + response.code());
    }
  }

  private String buscarLocationKey(String ciudad) throws IOException {
    Call<List<Map<String, Object>>> call = locationAPI.buscarCiudad(API_KEY, ciudad);
    Response<List<Map<String, Object>>> response = call.execute();

    if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
      return (String) response.body().get(0).get("Key");
    } else {
      return null;
    }
  }
}