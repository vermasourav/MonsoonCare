package com.monsoon.care.utils;

/**
 * Application-wide constants
 */
public class Constants {

    // API Configuration
    public static final String OPENWEATHER_API_KEY = "YOUR_API_KEY_HERE";
    public static final String WEATHER_API_TIMEOUT = "30";

    // Location
    public static final int DEFAULT_ZOOM_LEVEL = 12;
    public static final int LOCATION_UPDATE_INTERVAL = 300000; // 5 minutes

    // Alerts
    public static final String ALERT_TYPE_HEAVY_RAIN = "HEAVY_RAIN";
    public static final String ALERT_TYPE_FLOOD = "FLOOD";
    public static final String ALERT_TYPE_CYCLONE = "CYCLONE";
    public static final String ALERT_TYPE_LIGHTNING = "LIGHTNING";
    public static final String ALERT_TYPE_LANDSLIDE = "LANDSLIDE";
    public static final String ALERT_TYPE_DAM_RELEASE = "DAM_RELEASE";

    // Alert Severity
    public static final String SEVERITY_CRITICAL = "CRITICAL";
    public static final String SEVERITY_HIGH = "HIGH";
    public static final String SEVERITY_MEDIUM = "MEDIUM";
    public static final String SEVERITY_LOW = "LOW";

    // Checklist Categories
    public static final String CHECKLIST_HOME = "HOME";
    public static final String CHECKLIST_TRAVEL = "TRAVEL";
    public static final String CHECKLIST_FAMILY = "FAMILY";

    // Priority
    public static final String PRIORITY_HIGH = "HIGH";
    public static final String PRIORITY_MEDIUM = "MEDIUM";
    public static final String PRIORITY_LOW = "LOW";

    // Shared Preferences Keys
    public static final String PREF_USER_ID = "user_id";
    public static final String PREF_USER_NAME = "user_name";
    public static final String PREF_USER_EMAIL = "user_email";
    public static final String PREF_USER_LOCATION = "user_location";
    public static final String PREF_LATITUDE = "latitude";
    public static final String PREF_LONGITUDE = "longitude";
    public static final String PREF_LANGUAGE = "preferred_language";
    public static final String PREF_NOTIFICATIONS_ENABLED = "notifications_enabled";
    public static final String PREF_LOCATION_ENABLED = "location_enabled";
    public static final String PREF_HIGH_CONTRAST = "high_contrast";
    public static final String PREF_IS_ONBOARDED = "is_onboarded";
    public static final String PREF_LAST_WEATHER_UPDATE = "last_weather_update";

    // Database
    public static final String DB_NAME = "monsoon_care_db";
    public static final int DB_VERSION = 1;

    // Notification
    public static final String NOTIFICATION_CHANNEL_ALERTS = "monsoon_alerts";
    public static final String NOTIFICATION_CHANNEL_WEATHER = "weather_updates";
    public static final int NOTIFICATION_ID_ALERT = 1;
    public static final int NOTIFICATION_ID_WEATHER = 2;

    // Cache
    public static final long CACHE_WEATHER_DURATION = 600000; // 10 minutes
    public static final long CACHE_ALERTS_DURATION = 300000; // 5 minutes

    // Rate Limits
    public static final int MAX_API_CALLS_PER_MINUTE = 60;
    public static final int REQUEST_TIMEOUT_SECONDS = 30;

    // Language Codes
    public static final String LANG_ENGLISH = "en";
    public static final String LANG_HINDI = "hi";
    public static final String LANG_KANNADA = "kn";
    public static final String LANG_TAMIL = "ta";
    public static final String LANG_TELUGU = "te";
    public static final String LANG_BENGALI = "bn";
    public static final String LANG_MARATHI = "mr";

    // Default Values
    public static final String DEFAULT_LANGUAGE = LANG_ENGLISH;
    public static final String DEFAULT_LOCATION = "India";
}

