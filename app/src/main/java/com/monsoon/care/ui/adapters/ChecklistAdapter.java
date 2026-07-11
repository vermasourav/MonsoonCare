package com.monsoon.care.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.monsoon.care.R;
import com.monsoon.care.data.models.ChecklistItem;
import java.util.List;

/**
 * Adapter for displaying checklist items in RecyclerView
 */
public class ChecklistAdapter extends RecyclerView.Adapter<ChecklistAdapter.ChecklistViewHolder> {

    private List<ChecklistItem> items;
    private UpdateCallback updateCallback;

    public interface UpdateCallback {
        void onUpdate();
    }

    public ChecklistAdapter(List<ChecklistItem> items, UpdateCallback callback) {
        this.items = items;
        this.updateCallback = callback;
    }

    @Override
    public ChecklistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_checklist, parent, false);
        return new ChecklistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChecklistViewHolder holder, int position) {
        ChecklistItem item = items.get(position);
        holder.titleView.setText(item.getTitle());
        holder.descriptionView.setText(item.getDescription());
        holder.categoryView.setText(item.getCategory());
        holder.priorityView.setText(item.getPriority());
        holder.checkBox.setChecked(item.isCompleted());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setCompleted(isChecked);
            if (updateCallback != null) {
                updateCallback.onUpdate();
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<ChecklistItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public int getCompletedCount() {
        int count = 0;
        for (ChecklistItem item : items) {
            if (item.isCompleted()) count++;
        }
        return count;
    }

    static class ChecklistViewHolder extends RecyclerView.ViewHolder {
        TextView titleView, descriptionView, categoryView, priorityView;
        CheckBox checkBox;

        ChecklistViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.checklist_title);
            descriptionView = itemView.findViewById(R.id.checklist_description);
            categoryView = itemView.findViewById(R.id.checklist_category);
            priorityView = itemView.findViewById(R.id.checklist_priority);
            checkBox = itemView.findViewById(R.id.checklist_checkbox);
        }
    }
}

