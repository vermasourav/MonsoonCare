package com.monsoon.care.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.monsoon.care.R;
import com.monsoon.care.ui.adapters.AlertAdapter;
import com.monsoon.care.data.models.Alert;
import java.util.ArrayList;
import java.util.List;

/**
 * Main Dashboard Activity - Central hub showing weather, alerts, and quick access to features
 */
public class MainActivity extends AppCompatActivity {

    private TextView weatherTemp, weatherCondition, location;
    private ImageView weatherIcon;
    private RecyclerView alertsRecyclerView;
    private AlertAdapter alertAdapter;
    private Button weatherDetailBtn, preparednessPlanBtn, checklistBtn, travelAdvisoryBtn, communityBtn, aiAssistantBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupClickListeners();
        loadWeatherData();
        loadAlerts();
    }

    private void initializeViews() {
        weatherTemp = findViewById(R.id.weather_temp);
        weatherCondition = findViewById(R.id.weather_condition);
        location = findViewById(R.id.location);
        weatherIcon = findViewById(R.id.weather_icon);
        alertsRecyclerView = findViewById(R.id.alerts_recycler);

        weatherDetailBtn = findViewById(R.id.btn_weather_detail);
        preparednessPlanBtn = findViewById(R.id.btn_preparedness);
        checklistBtn = findViewById(R.id.btn_checklist);
        travelAdvisoryBtn = findViewById(R.id.btn_travel_advisory);
        communityBtn = findViewById(R.id.btn_community);
        aiAssistantBtn = findViewById(R.id.btn_ai_assistant);

        // Setup RecyclerView
        alertsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        alertAdapter = new AlertAdapter(new ArrayList<>());
        alertsRecyclerView.setAdapter(alertAdapter);
    }

    private void setupClickListeners() {
        weatherDetailBtn.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, WeatherDetailActivity.class)));

        preparednessPlanBtn.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, PreparednessActivity.class)));

        checklistBtn.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, ChecklistActivity.class)));

        travelAdvisoryBtn.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, TravelAdvisoryActivity.class)));

        communityBtn.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, CommunityActivity.class)));

        aiAssistantBtn.setOnClickListener(v ->
            startActivity(new Intent(MainActivity.this, AISafetyAssistantActivity.class)));
    }

    private void loadWeatherData() {
        // Placeholder - will be replaced with actual API call
        weatherTemp.setText("28°C");
        weatherCondition.setText("Partly Cloudy");
        location.setText(getSharedPreferences("MonsoonCare", MODE_PRIVATE)
                .getString("user_location", "Unknown Location"));
    }

    private void loadAlerts() {
        // Placeholder - will be replaced with actual API call
        List<Alert> alerts = new ArrayList<>();
        alerts.add(new Alert("1", "HEAVY_RAIN", "HIGH", "Heavy Rain Alert",
                "Heavy rainfall expected in your area", "Your Location", System.currentTimeMillis() + ""));
        alertAdapter.setAlerts(alerts);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh weather data when activity resumes
        loadWeatherData();
    }
}

