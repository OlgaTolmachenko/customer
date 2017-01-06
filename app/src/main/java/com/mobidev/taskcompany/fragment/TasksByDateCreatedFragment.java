package com.mobidev.taskcompany.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
<<<<<<< HEAD
<<<<<<< HEAD
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.model.Task;
<<<<<<< HEAD
import com.mobidev.taskcompany.util.TaskAdapter;
import com.mobidev.taskcompany.util.TaskDecorator;
<<<<<<< HEAD
=======
import com.mobidev.taskcompany.company.R;
=======
import com.mobidev.taskcompany.R;
>>>>>>> 3497b4d... refactoring
import com.mobidev.taskcompany.model.Task;
import com.mobidev.taskcompany.util.TaskAdapter;
>>>>>>> dabb3d3... Implement taskpager fragments
=======
>>>>>>> 762f2c5... Add status NEW when creating tasks. Add ItemDecorator to tasks recyclerview. Fix margins. Add task random title and body
=======
import com.mobidev.taskcompany.util.Constants;
>>>>>>> 1335be7... Refactor resources

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Olga Tolmachenko on 23.01.17.
 */

public class TasksByDateCreatedFragment extends BaseFragment {

<<<<<<< HEAD
    private List<Task> tasks;
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private TaskAdapter taskAdapter;
>>>>>>> dabb3d3... Implement taskpager fragments
=======
>>>>>>> 64f37b7... Add progressBars
=======
    private ArrayList<Task> tasks;

    public static TasksByDateCreatedFragment newInstance(String taskList) {
        TasksByDateCreatedFragment myFragment = new TasksByDateCreatedFragment();
        Bundle args = new Bundle();
        args.putString(Constants.TASKS, taskList);
        myFragment.setArguments(args);

        return myFragment;
    }
>>>>>>> 1335be7... Refactor resources

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_collection_tasks, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Gson gson = new Gson();
            String json = bundle.getString(Constants.TASKS, "");
            Type type = new TypeToken<ArrayList<Task>>(){}.getType();
            tasks = gson.fromJson(json, type);

            Collections.sort(tasks, new Comparator<Task>() {
                @Override
                public int compare(Task task, Task t1) {
                    return t1.getTimeCreated().compareTo(task.getTimeCreated());
                }
            });
        }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        TaskAdapter taskAdapter = new TaskAdapter(tasks);
=======
        taskAdapter = new TaskAdapter(tasks);
>>>>>>> dabb3d3... Implement taskpager fragments
=======
        TaskAdapter taskAdapter = new TaskAdapter(tasks);
>>>>>>> 64f37b7... Add progressBars

        RecyclerView taskRecyclerView = (RecyclerView) rootView.findViewById(R.id.taskRecycler);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        taskRecyclerView.setAdapter(taskAdapter);
<<<<<<< HEAD
<<<<<<< HEAD
        RecyclerView.ItemDecoration taskDecor = new TaskDecorator(getActivity().getDrawable(R.drawable.list_divider));
        taskRecyclerView.addItemDecoration(taskDecor);
=======

>>>>>>> dabb3d3... Implement taskpager fragments
=======
        RecyclerView.ItemDecoration taskDecor = new TaskDecorator(getActivity().getDrawable(R.drawable.list_divider));
        taskRecyclerView.addItemDecoration(taskDecor);
>>>>>>> 762f2c5... Add status NEW when creating tasks. Add ItemDecorator to tasks recyclerview. Fix margins. Add task random title and body
=======
        setUpRecycler(rootView, tasks);
>>>>>>> 1335be7... Refactor resources
        return rootView;
    }

    @Override
    public String toString() {
        return "By Date Created";
    }
}