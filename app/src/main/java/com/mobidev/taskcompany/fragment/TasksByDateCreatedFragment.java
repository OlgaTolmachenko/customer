package com.mobidev.taskcompany.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.model.Task;
import com.mobidev.taskcompany.util.Constants;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Olga Tolmachenko on 23.01.17.
 */

public class TasksByDateCreatedFragment extends BaseFragment {

    private ArrayList<Task> tasks;

    public static TasksByDateCreatedFragment newInstance(String taskList) {
        TasksByDateCreatedFragment myFragment = new TasksByDateCreatedFragment();
        Bundle args = new Bundle();
        args.putString(Constants.TASKS, taskList);
        myFragment.setArguments(args);

        return myFragment;
    }

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

        setUpRecycler(rootView, tasks);
        return rootView;
    }

    @Override
    public String toString() {
        return "By Date Created";
    }
}