package com.mobidev.taskcompany.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.TaskApp;
import com.mobidev.taskcompany.model.Task;
import com.mobidev.taskcompany.util.DateTimeChooser;
import com.mobidev.taskcompany.util.Constants;
import com.mobidev.taskcompany.util.CurrentDateAndTimeFormatUtil;
import com.mobidev.taskcompany.util.TaskStatus;

import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

public class CreateTaskActivity extends BaseActivity {

    private TextInputLayout titleLayout;
    private TextInputLayout bodyLayout;
    private TextInputEditText titleField;
    private TextInputEditText bodyField;
    private Spinner categorySpinner;
    private TextView dateField;
    private TextView timeField;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        initViews();

        DateTimeChooser dateTimeChooser = new DateTimeChooser(this, timeField, dateField);
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateSetListener = dateTimeChooser.getOnDateSetListener(myCalendar);
        final TimePickerDialog.OnTimeSetListener timeSetListener = dateTimeChooser.getOnTimeSetListener(myCalendar);

        LinearLayout dateChooser = (LinearLayout) findViewById(R.id.dateChooser);
        LinearLayout timeChooser = (LinearLayout) findViewById(R.id.timeChooser);
        dateChooser.setOnClickListener(dateTimeChooser.setDateChooserClickListener(myCalendar, dateSetListener));
        timeChooser.setOnClickListener(dateTimeChooser.setTimeChooserClickListener(myCalendar, timeSetListener));
    }

    private void initViews() {
        titleLayout = (TextInputLayout) findViewById(R.id.titleLayout);
        bodyLayout = (TextInputLayout) findViewById(R.id.bodyLayout);
        titleField = (TextInputEditText) findViewById(R.id.title);
        bodyField = (TextInputEditText) findViewById(R.id.body);
        categorySpinner = (Spinner) findViewById(R.id.taskCategory);
        dateField = (TextView) findViewById(R.id.dateField);
        timeField = (TextView) findViewById(R.id.timeField);

        char randomLetter = getRandomLetter();
        titleField.setText(randomLetter + getString(R.string.random_task_title));
        bodyField.setText(getString(R.string.random_task_body));
        categorySpinner.setAdapter(getCategoryAdapter());
        dateField.setText(CurrentDateAndTimeFormatUtil.getCurrentDateFormatted());
        timeField.setText(CurrentDateAndTimeFormatUtil.getCurrentTimeFormatted());
    }

    @NonNull
    private ArrayAdapter<CharSequence> getCategoryAdapter() {
        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.categories,
                android.R.layout.simple_spinner_dropdown_item
        );
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return categoryAdapter;
    }

    private char getRandomLetter() {
        Random r = new Random();
        return (char) (r.nextInt(26) + 'a');
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_create_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:

                String taskId = UUID.randomUUID().toString();

                if (!isLessThanThree(titleField.getText().toString(), bodyLayout)
                        && !isLessThanThree(bodyField.getText().toString(), titleLayout)) {
                    return false;
                }

                Task currentTask = new Task(
                        taskId,
                        titleField.getText().toString(),
                        categorySpinner.getSelectedItem().toString(),
                        bodyField.getText().toString(),
                        CurrentDateAndTimeFormatUtil.getCurrentDateAndTimeFormatted(),
                        getFullDueDateAndTime(),
                        TaskApp.getInstance().getCurrentCustomer(),
                        TaskStatus.NEW
                );

                TaskApp.getInstance().setTaskList(currentTask);

                hideKeyboard();
                showProgress();

                FirebaseDatabase.getInstance().getReference().child(Constants.FirebaseReferences.TASKS).child(taskId).setValue(currentTask).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        hideProgress();
                    }
                });

                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private boolean isLessThanThree(String input, TextInputLayout inputLayout) {
        boolean isLess;
        if (input.length() < 3) {
            inputLayout.setErrorEnabled(true);
            inputLayout.setError(getString(R.string.text_length_warning));
            isLess = true;
        } else {
            isLess = false;
        }
        return isLess;
    }

    private String getFullDueDateAndTime() {
        return dateField.getText().toString() + " " + timeField.getText().toString();
    }
}