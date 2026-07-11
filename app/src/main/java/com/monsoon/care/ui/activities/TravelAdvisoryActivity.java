package com.monsoon.care.ui.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.monsoon.care.R;
import com.monsoon.care.ui.adapters.TravelAdvisoryAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 * Travel Advisory Activity - Provides travel guidance and route information
 * - Road conditions
 * - Traffic disruptions
 * - Safe travel timing
 * - Route recommendations
 */
public class TravelAdvisoryActivity extends AppCompatActivity {

    private RecyclerView advisoryRecyclerView;
    private TravelAdvisoryAdapter advisoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_advisory);

        advisoryRecyclerView = findViewById(R.id.advisory_recycler);
        setupRecyclerView();
        loadAdvisories();
    }

    private void setupRecyclerView() {
        advisoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        advisoryAdapter = new TravelAdvisoryAdapter(new ArrayList<>());
        advisoryRecyclerView.setAdapter(advisoryAdapter);
    }

    private void loadAdvisories() {
        List<HashMap<String, String>> advisories = new ArrayList<>();

        HashMap<String, String> advisory1 = new HashMap<>();
        advisory1.put("route", "Ring Road - North Section");
        advisory1.put("status", "Flooded");
        advisory1.put("recommendation", "Avoid this route");
        advisory1.put("safeTime", "N/A");
        advisories.add(advisory1);

        HashMap<String, String> advisory2 = new HashMap<>();
        advisory2.put("route", "Express Highway - South");
        advisory2.put("status", "Moderate Traffic");
        advisory2.put("recommendation", "Use alternative routes");
        advisory2.put("safeTime", "After 6 PM");
        advisories.add(advisory2);

        HashMap<String, String> advisory3 = new HashMap<>();
        advisory3.put("route", "Public Transport");
        advisory3.put("status", "Delayed Services");
        advisory3.put("recommendation", "Bus services running 30 mins late");
        advisory3.put("safeTime", "Morning hours preferred");
        advisories.add(advisory3);

        advisoryAdapter.setAdvisories(advisories);
    }
}

