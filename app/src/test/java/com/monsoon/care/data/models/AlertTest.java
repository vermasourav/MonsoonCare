package com.monsoon.care.data.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class AlertTest {

    @Test
    public void testAlertProperties() {
        long timestamp = System.currentTimeMillis();
        Alert alert = new Alert("1", "FLOOD", "SEVERE", "Flood Warning", "Stay indoors", "Mumbai", timestamp);

        assertEquals("1", alert.getId());
        assertEquals("FLOOD", alert.getType());
        assertEquals("SEVERE", alert.getSeverity());
        assertEquals("Flood Warning", alert.getTitle());
        assertEquals("Stay indoors", alert.getMessage());
        assertEquals("Mumbai", alert.getLocation());
        assertEquals(timestamp, alert.getTimestamp());
        assertFalse(alert.isRead());

        alert.setRead(true);
        assertTrue(alert.isRead());
        
        alert.setId("2");
        assertEquals("2", alert.getId());
    }
}
