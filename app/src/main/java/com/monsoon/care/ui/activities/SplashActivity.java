package com.monsoon.care.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.monsoon.care.R;

/**
 * Splash Activity - Shows app logo and splash screen on app launch
 */
public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Add a handler to delay transition to next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Check if user is already onboarded
                boolean isOnboarded = getSharedPreferences("MonsoonCare", MODE_PRIVATE)
                        .getBoolean("is_onboarded", false);

                Intent intent;
                if (isOnboarded) {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this, OnboardingActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}

