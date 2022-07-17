package com.example.weatherapplication;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherStatus {
    @SerializedName("name")
    private String name;
    @SerializedName("weather")
    private List<Weather> weatherList;
    @SerializedName("id")
    private int id;
    @SerializedName("main")
    private Main main;

    public WeatherStatus() {
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Weather> getWeatherList() {
        return weatherList;
    }

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
