package com.monsoon.care.data.models;

import java.util.List;

/**
 * AI-generated preparedness plan model
 */
public class PreparednessPlan {
    private String planId;
    private String userId;
    private String generatedAt;
    private List<String> generalRecommendations;
    private List<String> locationSpecificTips;
    private List<String> emergencyContacts;

    public PreparednessPlan() {}

    public PreparednessPlan(String planId, String userId, String generatedAt) {
        this.planId = planId;
        this.userId = userId;
        this.generatedAt = generatedAt;
    }

    // Getters and Setters
    public String getPlanId() { return planId; }
    public void setPlanId(String planId) { this.planId = planId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(String generatedAt) { this.generatedAt = generatedAt; }

    public List<String> getGeneralRecommendations() { return generalRecommendations; }
    public void setGeneralRecommendations(List<String> generalRecommendations) { this.generalRecommendations = generalRecommendations; }

    public List<String> getLocationSpecificTips() { return locationSpecificTips; }
    public void setLocationSpecificTips(List<String> locationSpecificTips) { this.locationSpecificTips = locationSpecificTips; }

    public List<String> getEmergencyContacts() { return emergencyContacts; }
    public void setEmergencyContacts(List<String> emergencyContacts) { this.emergencyContacts = emergencyContacts; }
}
