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
>>>>>>> 64f37b7... Add progressBars
=======
>>>>>>> 762f2c5... Add status NEW when creating tasks. Add ItemDecorator to tasks recyclerview. Fix margins. Add task random title and body
=======
import com.mobidev.taskcompany.util.Constants;
>>>>>>> 1335be7... Refactor resources

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
/**
 * Created by olga on 23.01.17.
 */

>>>>>>> 64f37b7... Add progressBars
=======
>>>>>>> 3497b4d... refactoring
public class TasksByNameFragment extends Fragment {
=======
public class TasksByNameFragment extends BaseFragment {
>>>>>>> 1335be7... Refactor resources

    private ArrayList<Task> tasks;

    public static TasksByNameFragment newInstance(String taskList) {
        TasksByNameFragment myFragment = new TasksByNameFragment();
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
                    return task.getTitle().compareTo(t1.getTitle());
                }
            });
        }

<<<<<<< HEAD
        TaskAdapter taskAdapter = new TaskAdapter(tasks);
        RecyclerView taskRecyclerView = (RecyclerView) rootView.findViewById(R.id.taskRecycler);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        taskRecyclerView.setAdapter(taskAdapter);
<<<<<<< HEAD
<<<<<<< HEAD
        RecyclerView.ItemDecoration taskDecor = new TaskDecorator(getActivity().getDrawable(R.drawable.list_divider));
        taskRecyclerView.addItemDecoration(taskDecor);
=======

>>>>>>> 64f37b7... Add progressBars
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
        return "By Title";
    }
}