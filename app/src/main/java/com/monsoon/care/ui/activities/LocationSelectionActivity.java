package com.monsoon.care.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.monsoon.care.R;

/**
 * Location Selection Activity - Allows users to select their location manually or via GPS
 */
public class LocationSelectionActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText locationInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selection);

        sharedPreferences = getSharedPreferences("MonsoonCare", MODE_PRIVATE);
        locationInput = findViewById(R.id.location_input);
        Button useGpsButton = findViewById(R.id.btn_use_gps);
        Button manualSelectButton = findViewById(R.id.btn_manual_select);
        Button continueButton = findViewById(R.id.btn_continue);

        useGpsButton.setOnClickListener(v -> {
            // Request location from GPS
            sharedPreferences.edit().putString("location_source", "gps").apply();
            Toast.makeText(this, "Using GPS location...", Toast.LENGTH_SHORT).show();
        });

        manualSelectButton.setOnClickListener(v -> {
            String location = locationInput.getText().toString().trim();
            if (!location.isEmpty()) {
                sharedPreferences.edit()
                        .putString("user_location", location)
                        .putString("location_source", "manual")
                        .apply();
                Toast.makeText(this, "Location saved: " + location, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please enter a location", Toast.LENGTH_SHORT).show();
            }
        });

        continueButton.setOnClickListener(v -> {
            String location = locationInput.getText().toString().trim();
            if (!location.isEmpty() || sharedPreferences.contains("user_location")) {
                completeOnboarding();
            } else {
                Toast.makeText(this, "Please select a location", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void completeOnboarding() {
        sharedPreferences.edit().putBoolean("is_onboarded", true).apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

