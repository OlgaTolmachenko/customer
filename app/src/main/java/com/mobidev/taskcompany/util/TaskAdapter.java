package com.mobidev.taskcompany.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.model.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        holder.titleTV.setText(taskList.get(position).getTitle());
        holder.categoryTV.setText(context.getString(R.string.text_category, taskList.get(position).getCategory()));
        holder.bodyTV.setText(taskList.get(position).getBody());
        holder.timeTV.setText(taskList.get(position).getTimeCreated());
        holder.dueTV.setText(context.getString(R.string.text_due, taskList.get(position).getDueDate()));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTV;
        public TextView categoryTV;
        public TextView bodyTV;
        public TextView timeTV;
        public TextView dueTV;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTV = (TextView) itemView.findViewById(R.id.titleTV);
            categoryTV = (TextView) itemView.findViewById(R.id.categoryTV);
            bodyTV = (TextView) itemView.findViewById(R.id.bodyTV);
            timeTV = (TextView) itemView.findViewById(R.id.timeTV);
            dueTV = (TextView) itemView.findViewById(R.id.dueTV);
        }
    }
}