package com.monsoon.care.utils;

import com.orhanobut.logger.Logger;

/**
 * Logging utility with levels
 */
public class LogUtil {

    public static void d(String tag, String message) {
        Logger.d("[" + tag + "] " + message);
    }

    public static void e(String tag, String message, Exception exception) {
        Logger.e(exception, "[" + tag + "] " + message);
    }

    public static void i(String tag, String message) {
        Logger.i("[" + tag + "] " + message);
    }

    public static void w(String tag, String message) {
        Logger.w("[" + tag + "] " + message);
    }

    public static void v(String tag, String message) {
        Logger.v("[" + tag + "] " + message);
    }

    public static void json(String tag, String json) {
        Logger.d("[" + tag + "]");
        Logger.json(json);
    }
}

