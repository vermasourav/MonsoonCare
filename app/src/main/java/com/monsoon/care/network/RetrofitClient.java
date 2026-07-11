package com.monsoon.care.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.concurrent.TimeUnit;

/**
 * Retrofit client initialization and configuration
 */
public class RetrofitClient {

    private static Retrofit weatherRetrofit;
    private static Retrofit aiRetrofit;
    private static Retrofit disasterRetrofit;

    private static final String WEATHER_BASE_URL = "https://api.openweathermap.org/";
    private static final String AI_BASE_URL = "https://api.generativeai.service/";
    private static final String DISASTER_BASE_URL = "https://api.disaster.management/";

    public static Retrofit getWeatherClient() {
        if (weatherRetrofit == null) {
            weatherRetrofit = new Retrofit.Builder()
                    .baseUrl(WEATHER_BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return weatherRetrofit;
    }

    public static Retrofit getAIClient() {
        if (aiRetrofit == null) {
            aiRetrofit = new Retrofit.Builder()
                    .baseUrl(AI_BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return aiRetrofit;
    }

    public static Retrofit getDisasterClient() {
        if (disasterRetrofit == null) {
            disasterRetrofit = new Retrofit.Builder()
                    .baseUrl(DISASTER_BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return disasterRetrofit;
    }

    private static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }
}

