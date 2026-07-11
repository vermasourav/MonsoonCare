package com.monsoon.care.data.models;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class PreparednessPlanTest {

    @Test
    public void testPreparednessPlanProperties() {
        PreparednessPlan plan = new PreparednessPlan("p1", "u1", "2026-06-01");

        assertEquals("p1", plan.getPlanId());
        assertEquals("u1", plan.getUserId());
        assertEquals("2026-06-01", plan.getGeneratedAt());

        List<String> recommendations = Arrays.asList("Keep battery backup", "Stock up on food");
        plan.setGeneralRecommendations(recommendations);
        assertEquals(recommendations, plan.getGeneralRecommendations());

        List<String> tips = Arrays.asList("Avoid low-lying areas", "Check local news");
        plan.setLocationSpecificTips(tips);
        assertEquals(tips, plan.getLocationSpecificTips());

        List<String> contacts = Arrays.asList("100", "101");
        plan.setEmergencyContacts(contacts);
        assertEquals(contacts, plan.getEmergencyContacts());
    }
}
