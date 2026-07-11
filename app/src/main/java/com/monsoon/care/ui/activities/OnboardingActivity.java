package com.monsoon.care.ui.activities;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.monsoon.care.R;

/**
 * Onboarding Activity - Guides users through initial setup
 * - Language selection
 * - Location permission
 * - Location selection
 * - Optional: Family member details
 */
public class OnboardingActivity extends AppCompatActivity {

    private static final int LOCATION_PERMISSION_REQUEST = 100;
    private Spinner languageSpinner;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        sharedPreferences = getSharedPreferences("MonsoonCare", MODE_PRIVATE);

        languageSpinner = findViewById(R.id.language_spinner);
        Button nextButton = findViewById(R.id.btn_next);

        // Setup language spinner
        String[] languages = {"English", "Hindi", "Kannada", "Tamil", "Telugu", "Bengali", "Marathi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        nextButton.setOnClickListener(v -> {
            String selectedLanguage = languageSpinner.getSelectedItem().toString();
            sharedPreferences.edit().putString("preferred_language", selectedLanguage).apply();
            requestLocationPermission();
        });
    }

    private void requestLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        LOCATION_PERMISSION_REQUEST);
            } else {
                proceedToLocationSelection();
            }
        } else {
            proceedToLocationSelection();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                sharedPreferences.edit().putBoolean("location_enabled", true).apply();
                proceedToLocationSelection();
            } else {
                Toast.makeText(this, "Location permission is required", Toast.LENGTH_SHORT).show();
                sharedPreferences.edit().putBoolean("location_enabled", false).apply();
                proceedToLocationSelection();
            }
        }
    }

    private void proceedToLocationSelection() {
        Intent intent = new Intent(this, LocationSelectionActivity.class);
        startActivity(intent);
        finish();
    }
}

