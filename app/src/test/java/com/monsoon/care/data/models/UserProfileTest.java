package com.monsoon.care.data.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserProfileTest {

    @Test
    public void testUserProfileProperties() {
        UserProfile profile = new UserProfile("u1", "John", "john@example.com", "12345", "en", "Mumbai", 19.0, 72.0, true, true);

        assertEquals("u1", profile.getUserId());
        assertEquals("John", profile.getName());
        assertEquals("john@example.com", profile.getEmail());
        assertEquals("12345", profile.getPhoneNumber());
        assertEquals("en", profile.getPreferredLanguage());
        assertEquals("Mumbai", profile.getLocation());
        assertEquals(19.0, profile.getLatitude(), 0.1);
        assertEquals(72.0, profile.getLongitude(), 0.1);
        assertTrue(profile.isNotificationsEnabled());
        assertTrue(profile.isLocationEnabled());

        profile.setFamilySize("4");
        assertEquals("4", profile.getFamilySize());
        
        profile.setHasElderlyMembers(true);
        assertTrue(profile.isHasElderlyMembers());
        
        profile.setHasChildren(true);
        assertTrue(profile.isHasChildren());
        
        profile.setHasPets(true);
        assertTrue(profile.isHasPets());
        
        profile.setHealthConditions("Asthma");
        assertEquals("Asthma", profile.getHealthConditions());
    }
}
