package com.monsoon.care.data.db.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Room database entity for Alert data
 */
@Entity(tableName = "alerts")
public class AlertEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String serverId;
    public String type;
    public String severity;
    public String title;
    public String message;
    public String location;
    public double latitude;
    public double longitude;
    public long timestamp;
    public long expiresAt;
    public boolean isRead;
    public boolean isSynced;

    public AlertEntity() {}

    public AlertEntity(String serverId, String type, String severity, String title,
                       String message, String location) {
        this.serverId = serverId;
        this.type = type;
        this.severity = severity;
        this.title = title;
        this.message = message;
        this.location = location;
        this.timestamp = System.currentTimeMillis();
    }
}

