package com.monsoon.care.ui.activities;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.monsoon.care.R;

/**
 * Weather Detail Activity - Shows detailed weather information
 * - Current conditions
 * - 7-day forecast
 * - Hourly forecast
 * - Weather alerts specific to location
 */
public class WeatherDetailActivity extends AppCompatActivity {

    private TextView currentTemp, weatherDesc, humidity, windSpeed, rainProb, feelsLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);

        currentTemp = findViewById(R.id.current_temp);
        weatherDesc = findViewById(R.id.weather_description);
        humidity = findViewById(R.id.humidity);
        windSpeed = findViewById(R.id.wind_speed);
        rainProb = findViewById(R.id.rain_probability);
        feelsLike = findViewById(R.id.feels_like);

        loadWeatherDetails();
    }

    private void loadWeatherDetails() {
        // Placeholder - Will be replaced with actual weather API integration
        currentTemp.setText("28°C");
        weatherDesc.setText("Partly Cloudy with occasional rain");
        humidity.setText("Humidity: 75%");
        windSpeed.setText("Wind Speed: 15 km/h");
        rainProb.setText("Rain Probability: 65%");
        feelsLike.setText("Feels Like: 30°C");
    }
}

