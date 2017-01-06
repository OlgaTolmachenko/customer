package com.mobidev.taskcompany.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.model.Task;
import com.mobidev.taskcompany.util.TaskAdapter;
import com.mobidev.taskcompany.util.TaskDecorator;

import java.util.ArrayList;

/**
 * Created by olga on 22.02.17.
 */

public class BaseFragment extends Fragment {

    protected void setUpRecycler(View rootView, ArrayList<Task> tasks) {
        TaskAdapter taskAdapter = new TaskAdapter(tasks);
        RecyclerView taskRecyclerView = (RecyclerView) rootView.findViewById(R.id.taskRecycler);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        taskRecyclerView.setAdapter(taskAdapter);
        RecyclerView.ItemDecoration taskDecor = new TaskDecorator(getActivity().getDrawable(R.drawable.list_divider));
        taskRecyclerView.addItemDecoration(taskDecor);
    }
}
