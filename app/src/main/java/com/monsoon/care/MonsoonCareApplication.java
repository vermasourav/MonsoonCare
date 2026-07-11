package com.monsoon.care;

import android.app.Application;
import com.monsoon.care.utils.PreferenceManager;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Base Application class - Application-wide initialization
 */
public class MonsoonCareApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Logger
        Logger.addLogAdapter(new AndroidLogAdapter());

        // Initialize PreferenceManager
        PreferenceManager.initialize(this);

        // Other initialization
        initializeCrashHandler();
    }

    private void initializeCrashHandler() {
        // Setup global exception handler for uncaught exceptions
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            Logger.e(exception, "Uncaught Exception");
            // Send to crash analytics
        });
    }
}

