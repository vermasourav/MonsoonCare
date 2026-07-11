package com.monsoon.care.ui.activities;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.monsoon.care.R;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Test
    public void mainActivity_showsDefaultWeather() {
        try (ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
            // Verify default temperature text is displayed (placeholder data)
            Espresso.onView(ViewMatchers.withId(R.id.weather_temp))
                    .check(ViewAssertions.matches(ViewMatchers.withText("28°C")));
        }
    }
}

