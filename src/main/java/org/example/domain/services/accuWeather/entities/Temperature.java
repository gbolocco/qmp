package org.example.domain.services.accuWeather.entities;

import com.google.gson.annotations.SerializedName;

public class Temperature {

  @SerializedName("Value")
  public float value;

  @SerializedName("Unit")
  public String unit;

  @SerializedName("UnitType")
  public int unitType;
}


