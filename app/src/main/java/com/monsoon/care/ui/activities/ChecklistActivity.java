package com.monsoon.care.ui.activities;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.monsoon.care.R;
import com.monsoon.care.data.models.ChecklistItem;
import com.monsoon.care.ui.adapters.ChecklistAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Checklist Activity - Shows emergency preparedness checklists
 * - Home checklist
 * - Travel checklist
 * - Family checklist
 * - AI-generated personalized checklist
 */
public class ChecklistActivity extends AppCompatActivity {

    private RecyclerView checklistRecyclerView;
    private ChecklistAdapter checklistAdapter;
    private ProgressBar completionProgress;
    private TextView completionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        checklistRecyclerView = findViewById(R.id.checklist_recycler);
        completionProgress = findViewById(R.id.completion_progress);
        completionText = findViewById(R.id.completion_text);

        setupRecyclerView();
        loadChecklists();
    }

    private void setupRecyclerView() {
        checklistRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        checklistAdapter = new ChecklistAdapter(new ArrayList<>(), this::updateProgress);
        checklistRecyclerView.setAdapter(checklistAdapter);
    }

    private void loadChecklists() {
        List<ChecklistItem> items = new ArrayList<>();

        // Home Checklist
        items.add(new ChecklistItem("1", "Store drinking water", "Store at least 2 liters per person", "HOME", "HIGH", "2024-07-15"));
        items.add(new ChecklistItem("2", "Charge mobile phones", "Fully charge all devices", "HOME", "HIGH", "2024-07-15"));
        items.add(new ChecklistItem("3", "Backup important documents", "Create digital backups", "HOME", "MEDIUM", "2024-07-15"));

        // Travel Checklist
        items.add(new ChecklistItem("4", "Pack raincoat", "Waterproof clothing essential", "TRAVEL", "HIGH", "2024-07-15"));
        items.add(new ChecklistItem("5", "Carry umbrella", "Compact umbrella for easy transport", "TRAVEL", "MEDIUM", "2024-07-15"));

        // Family Checklist
        items.add(new ChecklistItem("6", "Prepare children's medicines", "Keep medicines accessible", "FAMILY", "HIGH", "2024-07-15"));
        items.add(new ChecklistItem("7", "Emergency contacts updated", "Ensure all contacts are current", "FAMILY", "HIGH", "2024-07-15"));

        checklistAdapter.setItems(items);
        updateProgress();
    }

    private void updateProgress() {
        int completed = checklistAdapter.getCompletedCount();
        int total = checklistAdapter.getItemCount();
        int progress = total > 0 ? (completed * 100) / total : 0;

        completionProgress.setProgress(progress);
        completionText.setText(completed + "/" + total + " completed");
    }
}

