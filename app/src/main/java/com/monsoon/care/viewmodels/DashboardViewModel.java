package com.monsoon.care.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.monsoon.care.data.repository.WeatherRepository;
import com.monsoon.care.data.models.Weather;
import com.monsoon.care.data.models.Alert;
import java.util.List;

/**
 * ViewModel for Main Dashboard Activity
 * Handles weather and alert data management
 */
public class DashboardViewModel extends AndroidViewModel {

    private WeatherRepository weatherRepository;
    private MutableLiveData<Weather> currentWeatherLiveData;
    private MutableLiveData<List<Alert>> alertsLiveData;
    private MutableLiveData<Boolean> loadingState;
    private MutableLiveData<String> errorMessage;

    public DashboardViewModel(Application application) {
        this(application, new WeatherRepository());
    }

    public DashboardViewModel(Application application, WeatherRepository weatherRepository) {
        super(application);
        this.weatherRepository = weatherRepository;
        currentWeatherLiveData = new MutableLiveData<>();
        alertsLiveData = new MutableLiveData<>();
        loadingState = new MutableLiveData<>(false);
        errorMessage = new MutableLiveData<>();
    }

    public LiveData<Weather> getCurrentWeather() {
        return currentWeatherLiveData;
    }

    public LiveData<List<Alert>> getAlerts() {
        return alertsLiveData;
    }

    public LiveData<Boolean> getLoadingState() {
        return loadingState;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public void fetchWeatherData(double latitude, double longitude, String language) {
        loadingState.setValue(true);
        weatherRepository.getCurrentWeather(latitude, longitude, language,
                new WeatherRepository.WeatherCallback() {
            @Override
            public void onSuccess(Weather weather) {
                currentWeatherLiveData.setValue(weather);
                loadingState.setValue(false);
            }

            @Override
            public void onError(String error) {
                errorMessage.setValue(error);
                loadingState.setValue(false);
            }
        });
    }

    public void fetchAlerts(double latitude, double longitude, String location) {
        loadingState.setValue(true);
        weatherRepository.getAlerts(latitude, longitude, location,
                new WeatherRepository.AlertsCallback() {
            @Override
            public void onSuccess(List<Alert> alerts) {
                alertsLiveData.setValue(alerts);
                loadingState.setValue(false);
            }

            @Override
            public void onError(String error) {
                errorMessage.setValue(error);
                loadingState.setValue(false);
            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // Clean up resources
    }
}

