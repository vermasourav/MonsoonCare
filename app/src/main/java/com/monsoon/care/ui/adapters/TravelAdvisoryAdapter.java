package com.monsoon.care.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.monsoon.care.R;
import java.util.HashMap;
import java.util.List;

/**
 * Adapter for displaying travel advisories
 */
public class TravelAdvisoryAdapter extends RecyclerView.Adapter<TravelAdvisoryAdapter.AdvisoryViewHolder> {

    private List<HashMap<String, String>> advisories;

    public TravelAdvisoryAdapter(List<HashMap<String, String>> advisories) {
        this.advisories = advisories;
    }

    @Override
    public AdvisoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_travel_advisory, parent, false);
        return new AdvisoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdvisoryViewHolder holder, int position) {
        HashMap<String, String> advisory = advisories.get(position);
        holder.route.setText(advisory.get("route"));
        holder.status.setText(advisory.get("status"));
        holder.recommendation.setText(advisory.get("recommendation"));
        holder.safeTime.setText(advisory.get("safeTime"));
    }

    @Override
    public int getItemCount() {
        return advisories.size();
    }

    public void setAdvisories(List<HashMap<String, String>> advisories) {
        this.advisories = advisories;
        notifyDataSetChanged();
    }

    static class AdvisoryViewHolder extends RecyclerView.ViewHolder {
        TextView route, status, recommendation, safeTime;

        AdvisoryViewHolder(View itemView) {
            super(itemView);
            route = itemView.findViewById(R.id.advisory_route);
            status = itemView.findViewById(R.id.advisory_status);
            recommendation = itemView.findViewById(R.id.advisory_recommendation);
            safeTime = itemView.findViewById(R.id.advisory_safe_time);
        }
    }
}

