package com.monsoon.care.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.monsoon.care.R;
import com.monsoon.care.data.models.Alert;
import java.util.List;

/**
 * Adapter for displaying alerts in RecyclerView
 */
public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.AlertViewHolder> {

    private List<Alert> alerts;

    public AlertAdapter(List<Alert> alerts) {
        this.alerts = alerts;
    }

    @Override
    public AlertViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alert, parent, false);
        return new AlertViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlertViewHolder holder, int position) {
        Alert alert = alerts.get(position);
        holder.titleView.setText(alert.getTitle());
        holder.messageView.setText(alert.getMessage());
        holder.typeView.setText(alert.getType());
        holder.severityView.setText(alert.getSeverity());
        holder.locationView.setText(alert.getLocation());
    }

    @Override
    public int getItemCount() {
        return alerts.size();
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
        notifyDataSetChanged();
    }

    static class AlertViewHolder extends RecyclerView.ViewHolder {
        TextView titleView, messageView, typeView, severityView, locationView;

        AlertViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.alert_title);
            messageView = itemView.findViewById(R.id.alert_message);
            typeView = itemView.findViewById(R.id.alert_type);
            severityView = itemView.findViewById(R.id.alert_severity);
            locationView = itemView.findViewById(R.id.alert_location);
        }
    }
}

