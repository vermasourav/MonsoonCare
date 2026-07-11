package com.monsoon.care.data.models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Weather model verifying getters and setters
 */
public class WeatherTest {

    @Test
    public void testGettersAndSetters() {
        Weather w = new Weather();
        w.setId("id123");
        w.setLocation("Testville");
        w.setLatitude(12.34);
        w.setLongitude(56.78);
        w.setTemperature("30°C");
        w.setCondition("Sunny");
        w.setHumidity("10%");
        w.setWindSpeed("5 km/h");
        w.setRainProbability("0%");
        w.setTimestamp("2026-07-11T10:00:00Z");
        w.setIconResId(12345);

        assertEquals("id123", w.getId());
        assertEquals("Testville", w.getLocation());
        assertEquals(12.34, w.getLatitude(), 0.0001);
        assertEquals(56.78, w.getLongitude(), 0.0001);
        assertEquals("30°C", w.getTemperature());
        assertEquals("Sunny", w.getCondition());
        assertEquals("10%", w.getHumidity());
        assertEquals("5 km/h", w.getWindSpeed());
        assertEquals("0%", w.getRainProbability());
        assertEquals("2026-07-11T10:00:00Z", w.getTimestamp());
        assertEquals(12345, w.getIconResId());
    }
}

