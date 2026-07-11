package com.monsoon.care.data.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class ChecklistItemTest {

    @Test
    public void testChecklistItemProperties() {
        ChecklistItem item = new ChecklistItem("1", "Flashlight", "Check batteries", "HOME", "HIGH", "2026-06-01");

        assertEquals("1", item.getId());
        assertEquals("Flashlight", item.getTitle());
        assertEquals("Check batteries", item.getDescription());
        assertEquals("HOME", item.getCategory());
        assertEquals("HIGH", item.getPriority());
        assertEquals("2026-06-01", item.getDueDate());
        assertFalse(item.isCompleted());

        item.setCompleted(true);
        assertTrue(item.isCompleted());
        
        item.setCheckedBy("User1");
        assertEquals("User1", item.getCheckedBy());
        
        item.setCheckedAt("2026-06-01 10:00");
        assertEquals("2026-06-01 10:00", item.getCheckedAt());
    }
}
