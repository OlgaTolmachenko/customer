package com.mobidev.taskcompany.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
<<<<<<< HEAD

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.model.Task;
<<<<<<< HEAD
import com.mobidev.taskcompany.util.TaskAdapter;
import com.mobidev.taskcompany.util.TaskDecorator;
<<<<<<< HEAD
=======
import android.widget.TextView;
=======
>>>>>>> 3497b4d... refactoring

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mobidev.taskcompany.R;
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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
/**
 * Created by Olga Tolmachenko on 23.01.17.
 */

>>>>>>> dabb3d3... Implement taskpager fragments
=======
>>>>>>> 3497b4d... refactoring
public class TasksByDueDateFragment extends Fragment {
=======
public class TasksByDueDateFragment extends BaseFragment {
>>>>>>> 1335be7... Refactor resources

    private ArrayList<Task> tasks;

    public static TasksByDueDateFragment newInstance(String taskList) {
        TasksByDueDateFragment myFragment = new TasksByDueDateFragment();
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
                    return t1.getDueDate().compareTo(task.getDueDate());
                }
            });
        }

<<<<<<< HEAD
        taskAdapter = new TaskAdapter(tasks);

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
        return "By Due Date";
    }
}
