package com.monsoon.care.ui.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.switchmaterial.SwitchMaterial;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import com.monsoon.care.R;

/**
 * Settings Activity - User preferences and configuration
 */
public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SwitchMaterial notificationsSwitch, locationSwitch, highContrastSwitch;
    private Spinner languageSpinner, textSizeSpinner;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPreferences = getSharedPreferences("MonsoonCare", MODE_PRIVATE);

        notificationsSwitch = findViewById(R.id.notifications_switch);
        locationSwitch = findViewById(R.id.location_switch);
        highContrastSwitch = findViewById(R.id.high_contrast_switch);
        languageSpinner = findViewById(R.id.language_spinner);
        textSizeSpinner = findViewById(R.id.text_size_spinner);
        saveButton = findViewById(R.id.btn_save_settings);

        loadCurrentSettings();

        saveButton.setOnClickListener(v -> saveSettings());
    }

    private void loadCurrentSettings() {
        notificationsSwitch.setChecked(sharedPreferences.getBoolean("notifications_enabled", true));
        locationSwitch.setChecked(sharedPreferences.getBoolean("location_enabled", true));
        highContrastSwitch.setChecked(sharedPreferences.getBoolean("high_contrast", false));

        String[] languages = {"English", "Hindi", "Kannada", "Tamil", "Telugu", "Bengali", "Marathi"};
        ArrayAdapter<String> langAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        langAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(langAdapter);

        String prefLanguage = sharedPreferences.getString("preferred_language", "English");
        languageSpinner.setSelection(java.util.Arrays.asList(languages).indexOf(prefLanguage));

        String[] textSizes = {"Small", "Medium", "Large", "Extra Large"};
        ArrayAdapter<String> sizeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, textSizes);
        sizeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        textSizeSpinner.setAdapter(sizeAdapter);
    }

    private void saveSettings() {
        sharedPreferences.edit()
                .putBoolean("notifications_enabled", notificationsSwitch.isChecked())
                .putBoolean("location_enabled", locationSwitch.isChecked())
                .putBoolean("high_contrast", highContrastSwitch.isChecked())
                .putString("preferred_language", languageSpinner.getSelectedItem().toString())
                .putString("text_size", textSizeSpinner.getSelectedItem().toString())
                .apply();

        finish();
    }
}

