package com.mobidev.taskcompany.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.TaskApp;
import com.mobidev.taskcompany.model.Task;
import com.mobidev.taskcompany.util.ChooserUtil;
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
    private Spinner taskCategorySpinner;
    private TextView dateField;
    private TextView timeField;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        titleLayout = (TextInputLayout) findViewById(R.id.titleLayout);
        bodyLayout = (TextInputLayout) findViewById(R.id.bodyLayout);
        titleField = (TextInputEditText) findViewById(R.id.title);
        bodyField = (TextInputEditText) findViewById(R.id.body);
        taskCategorySpinner = (Spinner) findViewById(R.id.taskCategory);
        dateField = (TextView) findViewById(R.id.dateField);
        timeField = (TextView) findViewById(R.id.timeField);

        char randomLetter = getRandomLetter();
        titleField.setText(randomLetter + getString(R.string.random_task_title));
        bodyField.setText(getString(R.string.random_task_body));
        setTitleFieldScroll();
        setBodyFieldScroll();

        taskCategorySpinner.setAdapter(getCategoryAdapter());

        dateField.setText(CurrentDateAndTimeFormatUtil.getCurrentDateFormatted());
        timeField.setText(CurrentDateAndTimeFormatUtil.getCurrentTimeFormatted());

        ChooserUtil chooserUtil = new ChooserUtil(this, timeField, dateField);
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener dateSetListener = chooserUtil.getOnDateSetListener(myCalendar);
        final TimePickerDialog.OnTimeSetListener timeSetListener = chooserUtil.getOnTimeSetListener(myCalendar);

        LinearLayout dateChooser = (LinearLayout) findViewById(R.id.dateChooser);
        LinearLayout timeChooser = (LinearLayout) findViewById(R.id.timeChooser);
        dateChooser.setOnClickListener(chooserUtil.setDateChooserClickListener(myCalendar, dateSetListener));
        timeChooser.setOnClickListener(chooserUtil.setTimeChooserClickListener(myCalendar, timeSetListener));
    }

    private void setBodyFieldScroll() {
        int bodyMaxLines = 12;
        setScroll(bodyField, bodyMaxLines);
    }

    private void setTitleFieldScroll() {
        int titleMaxLines = 5;
        setScroll(titleField, titleMaxLines);
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

                if (!isLessThanThree(titleField.getText().toString(), titleLayout)
                        && !isLessThanThree(bodyField.getText().toString(), bodyLayout)) {
                    Task currentTask = new Task(
                            taskId,
                            titleField.getText().toString(),
                            taskCategorySpinner.getSelectedItem().toString(),
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
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setScroll(EditText field, int maxLines) {
        field.setScroller(new Scroller(this));
        field.setMaxLines(maxLines);
        field.setVerticalScrollBarEnabled(true);
        field.setMovementMethod(new ScrollingMovementMethod());
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