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
 * Adapter for displaying community reports
 */
public class CommunityReportAdapter extends RecyclerView.Adapter<CommunityReportAdapter.ReportViewHolder> {

    private List<HashMap<String, String>> reports;

    public CommunityReportAdapter(List<HashMap<String, String>> reports) {
        this.reports = reports;
    }

    @Override
    public ReportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_community_report, parent, false);
        return new ReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReportViewHolder holder, int position) {
        HashMap<String, String> report = reports.get(position);
        holder.type.setText(report.get("type"));
        holder.location.setText(report.get("location"));
        holder.reporter.setText("By: " + report.get("reporter"));
        holder.timestamp.setText(report.get("timestamp"));
        holder.severity.setText(report.get("severity"));
    }

    @Override
    public int getItemCount() {
        return reports.size();
    }

    public void setReports(List<HashMap<String, String>> reports) {
        this.reports = reports;
        notifyDataSetChanged();
    }

    static class ReportViewHolder extends RecyclerView.ViewHolder {
        TextView type, location, reporter, timestamp, severity;

        ReportViewHolder(View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.report_type);
            location = itemView.findViewById(R.id.report_location);
            reporter = itemView.findViewById(R.id.report_reporter);
            timestamp = itemView.findViewById(R.id.report_timestamp);
            severity = itemView.findViewById(R.id.report_severity);
        }
    }
}

