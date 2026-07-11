package com.monsoon.care.ui.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.monsoon.care.R;
import com.monsoon.care.ui.adapters.CommunityReportAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Community Assistance Activity - Enables citizen participation in reporting incidents
 * - Report flooded roads
 * - Report blocked routes
 * - Report fallen trees
 * - Report power outages
 * - Community coordination
 */
public class CommunityActivity extends AppCompatActivity {

    private RecyclerView reportsRecyclerView;
    private CommunityReportAdapter reportAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        reportsRecyclerView = findViewById(R.id.reports_recycler);
        setupRecyclerView();
        loadCommunityReports();
    }

    private void setupRecyclerView() {
        reportsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        reportAdapter = new CommunityReportAdapter(new ArrayList<>());
        reportsRecyclerView.setAdapter(reportAdapter);
    }

    private void loadCommunityReports() {
        List<HashMap<String, String>> reports = new ArrayList<>();

        HashMap<String, String> report1 = new HashMap<>();
        report1.put("type", "Flooded Road");
        report1.put("location", "Main Street near Market");
        report1.put("reporter", "John Doe");
        report1.put("timestamp", "2 hours ago");
        report1.put("severity", "HIGH");
        reports.add(report1);

        HashMap<String, String> report2 = new HashMap<>();
        report2.put("type", "Fallen Tree");
        report2.put("location", "Park Road");
        report2.put("reporter", "Jane Smith");
        report2.put("timestamp", "5 hours ago");
        report2.put("severity", "MEDIUM");
        reports.add(report2);

        HashMap<String, String> report3 = new HashMap<>();
        report3.put("type", "Power Outage");
        report3.put("location", "Sector 5");
        report3.put("reporter", "Community Admin");
        report3.put("timestamp", "1 hour ago");
        report3.put("severity", "HIGH");
        reports.add(report3);

        reportAdapter.setReports(reports);
    }
}

