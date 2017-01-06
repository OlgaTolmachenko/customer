package com.mobidev.taskcompany.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.model.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

=======
import com.mobidev.taskcompany.TaskApp;
=======
>>>>>>> 6b47303... multiple login
import com.mobidev.taskcompany.company.R;
=======
import com.mobidev.taskcompany.R;
>>>>>>> 3497b4d... refactoring
import com.mobidev.taskcompany.model.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

<<<<<<< HEAD
>>>>>>> d9e6e1c... Implmenting List
=======
    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

>>>>>>> f2858f9... temp
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> f2858f9... temp
=======
        Context context = holder.itemView.getContext();
>>>>>>> 1335be7... Refactor resources
        holder.titleTV.setText(taskList.get(position).getTitle());
        holder.categoryTV.setText(context.getString(R.string.text_category, taskList.get(position).getCategory()));
        holder.bodyTV.setText(taskList.get(position).getBody());
        holder.timeTV.setText(taskList.get(position).getTimeCreated());
<<<<<<< HEAD
        holder.dueTV.setText("Due date: " + taskList.get(position).getDueDate());
<<<<<<< HEAD
=======
        Task task = TaskApp.getInstance().getTaskList().get(position);
        holder.titleTV.setText(task.getTitle());
        holder.bodyTV.setText(task.getBody());
        holder.timeTV.setText(task.getTime());
>>>>>>> d9e6e1c... Implmenting List
=======
        holder.titleTV.setText(TaskApp.getInstance().getTaskList().get(position).getTitle());
        holder.categoryTV.setText("Category: " + TaskApp.getInstance().getTaskList().get(position).getCategory());
        holder.bodyTV.setText(TaskApp.getInstance().getTaskList().get(position).getBody());
<<<<<<< HEAD
        holder.timeTV.setText(TaskApp.getInstance().getTaskList().get(position).getTime());
>>>>>>> d00ba80... Implement DatePicker. Implement Category Spinner
=======
        holder.timeTV.setText(TaskApp.getInstance().getTaskList().get(position).getTimeCreated());
        holder.dueTV.setText("Due date: " + TaskApp.getInstance().getTaskList().get(position).getDueDate());
>>>>>>> 966923f... restructuring
=======
>>>>>>> f2858f9... temp
=======
        holder.dueTV.setText(context.getString(R.string.text_due, taskList.get(position).getDueDate()));
>>>>>>> 1335be7... Refactor resources
    }

    @Override
    public int getItemCount() {
<<<<<<< HEAD
<<<<<<< HEAD
        if (taskList.size() == 0) {
            return 0;
        }
        return taskList.size();
=======
        if (TaskApp.getInstance().getTaskList().isEmpty()) {
            return 0;
        }
        return TaskApp.getInstance().getTaskList().size();
>>>>>>> d9e6e1c... Implmenting List
=======
        if (taskList.size() == 0) {
            return 0;
        }
        return taskList.size();
>>>>>>> f2858f9... temp
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTV;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 966923f... restructuring
        public TextView categoryTV;
        public TextView bodyTV;
        public TextView timeTV;
        public TextView dueTV;
<<<<<<< HEAD
=======
        public TextView bodyTV;
        public TextView timeTV;
>>>>>>> d9e6e1c... Implmenting List
=======
>>>>>>> 966923f... restructuring

        public ViewHolder(View itemView) {
            super(itemView);
            titleTV = (TextView) itemView.findViewById(R.id.titleTV);
<<<<<<< HEAD
<<<<<<< HEAD
            categoryTV = (TextView) itemView.findViewById(R.id.categoryTV);
            bodyTV = (TextView) itemView.findViewById(R.id.bodyTV);
            timeTV = (TextView) itemView.findViewById(R.id.timeTV);
            dueTV = (TextView) itemView.findViewById(R.id.dueTV);
=======
            bodyTV = (TextView) itemView.findViewById(R.id.bodyTV);
            timeTV = (TextView) itemView.findViewById(R.id.timeTV);
>>>>>>> d9e6e1c... Implmenting List
=======
            categoryTV = (TextView) itemView.findViewById(R.id.categoryTV);
            bodyTV = (TextView) itemView.findViewById(R.id.bodyTV);
            timeTV = (TextView) itemView.findViewById(R.id.timeTV);
            dueTV = (TextView) itemView.findViewById(R.id.dueTV);
>>>>>>> 966923f... restructuring
        }
    }
}
