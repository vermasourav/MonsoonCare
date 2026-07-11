package com.monsoon.care.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

/**
 * Secure SharedPreferences utility with encryption
 */
public class PreferenceManager {

    private static SharedPreferences preferences;

    public static void initialize(Context context) {
        try {
            MasterKey masterKey = new MasterKey.Builder(context)
                    .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                    .build();

            preferences = EncryptedSharedPreferences.create(
                    context,
                    "monsoon_prefs",
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        } catch (Exception e) {
            LogUtil.e("PreferenceManager", "Error initializing encrypted preferences", e);
        }
    }

    public static void putString(String key, String value) {
        if (preferences != null) {
            preferences.edit().putString(key, value).apply();
        }
    }

    public static String getString(String key, String defaultValue) {
        if (preferences != null) {
            return preferences.getString(key, defaultValue);
        }
        return defaultValue;
    }

    public static void putInt(String key, int value) {
        if (preferences != null) {
            preferences.edit().putInt(key, value).apply();
        }
    }

    public static int getInt(String key, int defaultValue) {
        if (preferences != null) {
            return preferences.getInt(key, defaultValue);
        }
        return defaultValue;
    }

    public static void putBoolean(String key, boolean value) {
        if (preferences != null) {
            preferences.edit().putBoolean(key, value).apply();
        }
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        if (preferences != null) {
            return preferences.getBoolean(key, defaultValue);
        }
        return defaultValue;
    }

    public static void putLong(String key, long value) {
        if (preferences != null) {
            preferences.edit().putLong(key, value).apply();
        }
    }

    public static long getLong(String key, long defaultValue) {
        if (preferences != null) {
            return preferences.getLong(key, defaultValue);
        }
        return defaultValue;
    }

    public static void remove(String key) {
        if (preferences != null) {
            preferences.edit().remove(key).apply();
        }
    }

    public static void clear() {
        if (preferences != null) {
            preferences.edit().clear().apply();
        }
    }

    public static boolean contains(String key) {
        return preferences != null && preferences.contains(key);
    }
}

