package com.monsoon.care.data.models;

/**
 * User profile model with family members and preferences
 */
public class UserProfile {
    private String userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String preferredLanguage;
    private String location;
    private double latitude;
    private double longitude;
    private boolean notificationsEnabled;
    private boolean locationEnabled;
    private String familySize;
    private boolean hasElderlyMembers;
    private boolean hasChildren;
    private boolean hasPets;
    private String healthConditions;
    private String createdAt;
    private String updatedAt;

    public UserProfile() {}

    public UserProfile(String userId, String name, String email, String phoneNumber,
                       String preferredLanguage, String location, double latitude,
                       double longitude, boolean notificationsEnabled, boolean locationEnabled) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.preferredLanguage = preferredLanguage;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.notificationsEnabled = notificationsEnabled;
        this.locationEnabled = locationEnabled;
    }

    // Getters and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPreferredLanguage() { return preferredLanguage; }
    public void setPreferredLanguage(String preferredLanguage) { this.preferredLanguage = preferredLanguage; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public boolean isNotificationsEnabled() { return notificationsEnabled; }
    public void setNotificationsEnabled(boolean notificationsEnabled) { this.notificationsEnabled = notificationsEnabled; }

    public boolean isLocationEnabled() { return locationEnabled; }
    public void setLocationEnabled(boolean locationEnabled) { this.locationEnabled = locationEnabled; }

    public String getFamilySize() { return familySize; }
    public void setFamilySize(String familySize) { this.familySize = familySize; }

    public boolean isHasElderlyMembers() { return hasElderlyMembers; }
    public void setHasElderlyMembers(boolean hasElderlyMembers) { this.hasElderlyMembers = hasElderlyMembers; }

    public boolean isHasChildren() { return hasChildren; }
    public void setHasChildren(boolean hasChildren) { this.hasChildren = hasChildren; }

    public boolean isHasPets() { return hasPets; }
    public void setHasPets(boolean hasPets) { this.hasPets = hasPets; }

    public String getHealthConditions() { return healthConditions; }
    public void setHealthConditions(String healthConditions) { this.healthConditions = healthConditions; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}

