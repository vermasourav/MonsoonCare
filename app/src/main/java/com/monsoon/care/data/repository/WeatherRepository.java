package com.monsoon.care.data.repository;

import com.monsoon.care.data.models.Weather;
import com.monsoon.care.data.models.Alert;
import com.monsoon.care.network.WeatherApiService;
import com.monsoon.care.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

/**
 * Repository for weather data - implements Repository Pattern
 */
public class WeatherRepository {

    private WeatherApiService apiService;

    public WeatherRepository() {
        this.apiService = RetrofitClient.getWeatherClient()
                .create(WeatherApiService.class);
    }

    public void getCurrentWeather(double latitude, double longitude, String language,
                                  WeatherCallback callback) {
        apiService.getCurrentWeather(latitude, longitude, "metric", language)
                .enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            callback.onSuccess(response.body());
                        } else {
                            callback.onError("Failed to fetch weather");
                        }
                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {
                        callback.onError(t.getMessage());
                    }
                });
    }

    public void getAlerts(double latitude, double longitude, String location,
                          AlertsCallback callback) {
        apiService.getAlerts(latitude, longitude, location)
                .enqueue(new Callback<List<Alert>>() {
                    @Override
                    public void onResponse(Call<List<Alert>> call, Response<List<Alert>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            callback.onSuccess(response.body());
                        } else {
                            callback.onError("Failed to fetch alerts");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Alert>> call, Throwable t) {
                        callback.onError(t.getMessage());
                    }
                });
    }

    public interface WeatherCallback {
        void onSuccess(Weather weather);

        void onError(String error);
    }

    public interface AlertsCallback {
        void onSuccess(List<Alert> alerts);

        void onError(String error);
    }
}

