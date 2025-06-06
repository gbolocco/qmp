package org.example.domain.services.accuWeather.entities;

import com.google.gson.annotations.SerializedName;

public class Clima {

  @SerializedName("Temperature")
  public Temperature temperature;

  @SerializedName("HasPrecipitation")
  public boolean hasPrecipitation;

  @SerializedName("PrecipitationProbability")
  public int precipitationProbability;

  @SerializedName("IconPhrase")
  public String iconPhrase;
}


