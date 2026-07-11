package com.monsoon.care.data.models;

/**
 * Alert data model for monsoon-related alerts
 */
public class Alert {
    private String id;
    private String type;
    private String severity;
    private String title;
    private String message;
    private String location;
    private long timestamp;
    private boolean isRead;

    public Alert() {}

    public Alert(String id, String type, String severity, String title, String message, String location, long timestamp) {
        this.id = id;
        this.type = type;
        this.severity = severity;
        this.title = title;
        this.message = message;
        this.location = location;
        this.timestamp = timestamp;
        this.isRead = false;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    public boolean isRead() { return isRead; }
    public void setRead(boolean read) { isRead = read; }
}
