package com.monsoon.care.data.models;

/**
 * Weather data model for current weather information
 */
public class Weather {
    private String id;
    private String location;
    private double latitude;
    private double longitude;
    private String temperature;
    private String condition;
    private String humidity;
    private String windSpeed;
    private String rainProbability;
    private String timestamp;
    private int iconResId;

    public Weather() {}

    public Weather(String id, String location, double latitude, double longitude,
                   String temperature, String condition, String humidity,
                   String windSpeed, String rainProbability, String timestamp, int iconResId) {
        this.id = id;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperature = temperature;
        this.condition = condition;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.rainProbability = rainProbability;
        this.timestamp = timestamp;
        this.iconResId = iconResId;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getTemperature() { return temperature; }
    public void setTemperature(String temperature) { this.temperature = temperature; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public String getHumidity() { return humidity; }
    public void setHumidity(String humidity) { this.humidity = humidity; }

    public String getWindSpeed() { return windSpeed; }
    public void setWindSpeed(String windSpeed) { this.windSpeed = windSpeed; }

    public String getRainProbability() { return rainProbability; }
    public void setRainProbability(String rainProbability) { this.rainProbability = rainProbability; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public int getIconResId() { return iconResId; }
    public void setIconResId(int iconResId) { this.iconResId = iconResId; }
}

