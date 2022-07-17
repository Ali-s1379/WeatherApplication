package com.example.weatherapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("weather")
    Call<WeatherStatus> getCurrentWeather(@Query("q") String cityName,@Query("appid") String query);
}
