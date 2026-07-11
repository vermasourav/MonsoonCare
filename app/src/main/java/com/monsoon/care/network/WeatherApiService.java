package com.monsoon.care.network;

import com.monsoon.care.data.models.Weather;
import com.monsoon.care.data.models.Alert;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import java.util.List;

/**
 * Retrofit API service for weather and alert data
 */
public interface WeatherApiService {

    @GET("weather")
    Call<Weather> getCurrentWeather(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("units") String units,
            @Query("lang") String language
    );

    @GET("forecast")
    Call<List<Weather>> getForecast(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("days") int days
    );

    @GET("alerts")
    Call<List<Alert>> getAlerts(
            @Query("lat") double latitude,
            @Query("lon") double longitude,
            @Query("location") String location
    );
}

