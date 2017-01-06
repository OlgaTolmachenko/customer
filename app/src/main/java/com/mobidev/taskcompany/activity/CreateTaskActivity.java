package com.mobidev.taskcompany.activity;

<<<<<<< HEAD
<<<<<<< HEAD
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
<<<<<<< HEAD
=======
=======
import android.app.DatePickerDialog;
<<<<<<< HEAD
<<<<<<< HEAD
import android.app.Dialog;
import android.app.DialogFragment;
>>>>>>> d00ba80... Implement DatePicker. Implement Category Spinner
=======
>>>>>>> 966923f... restructuring
=======
import android.app.TimePickerDialog;
>>>>>>> 544cce7... Add Time Picker to CreateActivity
import android.content.Intent;
>>>>>>> d184d09... Task creation and DB saving added
=======
>>>>>>> 16aeccd... Set send both Due date and time
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
<<<<<<< HEAD
<<<<<<< HEAD
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.mobidev.taskcompany.R;
import com.mobidev.taskcompany.TaskApp;
import com.mobidev.taskcompany.model.Customer;
import com.mobidev.taskcompany.model.Task;
import com.mobidev.taskcompany.model.TaskLatLng;
import com.mobidev.taskcompany.util.Constants;
import com.mobidev.taskcompany.util.FirebaseReferences;
import com.mobidev.taskcompany.util.TaskStatus;

import java.text.SimpleDateFormat;
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
=======
import android.support.v7.app.AppCompatActivity;
=======
>>>>>>> 3497b4d... refactoring
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

<<<<<<< HEAD
    TextInputLayout titleLayout;
    TextInputLayout bodyLayout;
    TextInputEditText titleField;
    TextInputEditText bodyField;
    Button btnSave;
>>>>>>> d184d09... Task creation and DB saving added
=======
    private TextInputLayout titleLayout;
    private TextInputLayout bodyLayout;
    private TextInputEditText titleField;
    private TextInputEditText bodyField;
    private Spinner taskCategorySpinner;
<<<<<<< HEAD
    private EditText dateField;
>>>>>>> d00ba80... Implement DatePicker. Implement Category Spinner
=======
    private TextView dateField;
    private TextView timeField;
>>>>>>> 544cce7... Add Time Picker to CreateActivity

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

=======
>>>>>>> d184d09... Task creation and DB saving added
=======
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    startActivity(new Intent(CreateTaskActivity.this, SignInActivity.class).setFlags(FLAG_ACTIVITY_CLEAR_TASK | FLAG_ACTIVITY_NEW_TASK));
                    ValueEventListener customerListener = getCustomerEventListener();
                    FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(customerListener);
//                    customerListener = getCustomerEventListener();
//                    FirebaseDatabase.getInstance().getReference("customers").child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(customerListener);
                } else {
                    Log.d("LOG", "onAuthStateChanged: ");
                }
            }
        };

        FirebaseAuth.getInstance().addAuthStateListener(authStateListener);
=======
//        authStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                if (firebaseAuth.getCurrentUser() == null) {
//                    startActivity(new Intent(CreateTaskActivity.this, SignInActivity.class).setFlags(FLAG_ACTIVITY_CLEAR_TASK | FLAG_ACTIVITY_NEW_TASK));
//                    ValueEventListener customerListener = getCustomerEventListener();
//                    FirebaseDatabase.getInstance().getReference().addListenerForSingleValueEvent(customerListener);
////                    customerListener = getCustomerEventListener();
////                    FirebaseDatabase.getInstance().getReference("customers").child(firebaseAuth.getCurrentUser().getUid()).addValueEventListener(customerListener);
//                } else {
//                    Log.d("LOG", "onAuthStateChanged: ");
//                }
//            }
//        };

//        FirebaseAuth.getInstance().addAuthStateListener(authStateListener);
>>>>>>> dabb3d3... Implement taskpager fragments

>>>>>>> 6b47303... multiple login
=======
>>>>>>> 64f37b7... Add progressBars
=======
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

>>>>>>> 3b9bd70... Bugfix
        titleLayout = (TextInputLayout) findViewById(R.id.titleLayout);
        bodyLayout = (TextInputLayout) findViewById(R.id.bodyLayout);
        titleField = (TextInputEditText) findViewById(R.id.title);
        bodyField = (TextInputEditText) findViewById(R.id.body);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        taskCategorySpinner = (Spinner) findViewById(R.id.taskCategory);
        dateField = (TextView) findViewById(R.id.dateField);
        timeField = (TextView) findViewById(R.id.timeField);

        char randomLetter = getRandomLetter();
        titleField.setText(randomLetter + getResources().getString(R.string.random_task_title));
        int titleMaxLines = 5;
        int bodyMaxLines = 12;
        setScroll(titleField, titleMaxLines);
        setScroll(bodyField, bodyMaxLines);

        ArrayAdapter<CharSequence> categoryAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.categories,
                android.R.layout.simple_spinner_dropdown_item
        );
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        taskCategorySpinner.setAdapter(categoryAdapter);

        final Calendar myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                showDate(dayOfMonth, monthOfYear + 1, year);
            }
        };

        final TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                myCalendar.set(Calendar.HOUR, hourOfDay);
                myCalendar.set(Calendar.MINUTE, minute);
                showTime(hourOfDay, minute);
            }
        };

        dateField.setText(getCurrentDateFormatted());
        timeField.setText(getCurrentTimeFormatted());

        dateField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CreateTaskActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        timeField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(CreateTaskActivity.this, time, myCalendar
                        .get(Calendar.HOUR), myCalendar.get(Calendar.MINUTE),
                        true).show();
=======
        btnSave = (Button) findViewById(R.id.btnSave);
=======
        Button btnSave = (Button) findViewById(R.id.btnSave);
>>>>>>> 64f37b7... Add progressBars
=======
>>>>>>> aee538b... bugfix
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
<<<<<<< HEAD
                String title = titleField.getText().toString();
                String body = bodyField.getText().toString();
                Customer currentCustomer = TaskApp.getInstance().getCurrentCustomer();
                TaskLatLng currentCustomerLocation = currentCustomer.getLocation();
                String currentCustomerName = currentCustomer.getName();
                String currentCustomerLogo = currentCustomer.getLogo();
                String currentCustomerAddress = currentCustomer.getAddress();
<<<<<<< HEAD

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
            if (!isLessThanThree(title, titleLayout) || !isLessThanThree(body, bodyLayout)) {
                String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";

                Task currentTask = new Task(
                        title,
                        taskCategorySpinner.getSelectedItem().toString(),
                        body,
                        getCurrentTimeFormatted(DATE_FORMAT),
                        dateField.getText().toString(),
                        new Customer(currentCustomerName, null, null, currentCustomerLogo, currentCustomerLocation, currentCustomerAddress),
                        currentCustomer.getUid()
                );

                TaskApp.getInstance().setTaskList(currentTask);

                hideKeyboard();
                showProgress();
                getDB().child("tasks").child(UUID.randomUUID().toString()).setValue(currentTask).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        hideProgress();
                    }
                });

<<<<<<< HEAD
<<<<<<< HEAD
                startActivity(new Intent(CreateTaskActivity.this, MainActivity.class)
<<<<<<< HEAD
                        .putExtra("task", currentTask));
>>>>>>> d184d09... Task creation and DB saving added
=======
                        .setFlags(FLAG_ACTIVITY_CLEAR_TASK | FLAG_ACTIVITY_NEW_TASK));
>>>>>>> d9e6e1c... Implmenting List
=======
>>>>>>> d00ba80... Implement DatePicker. Implement Category Spinner
=======
                startActivity(new Intent(CreateTaskActivity.this, MainActivity.class)
                        .setFlags(FLAG_ACTIVITY_CLEAR_TASK | FLAG_ACTIVITY_NEW_TASK));
<<<<<<< HEAD
            }
>>>>>>> 966923f... restructuring
=======
                }
>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
            }
        });
=======
                if (!isLessThanThree(title, titleLayout) || !isLessThanThree(body, bodyLayout)) {
=======
=======
                String taskId = UUID.randomUUID().toString();
>>>>>>> 9246afa... fix creating and sending task
                if (!isLessThanThree(title, titleLayout) && !isLessThanThree(body, bodyLayout)) {
<<<<<<< HEAD
>>>>>>> 8eef402... Fix CreateActivity sending tasks bug.
                    String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";
=======
>>>>>>> 544cce7... Add Time Picker to CreateActivity

                    Task currentTask = new Task(
                            taskId,
                            title,
                            taskCategorySpinner.getSelectedItem().toString(),
                            body,
                            getCurrentDateAndTimeFormatted(),
                            getFullDueDateAndTime(),
                            new Customer(currentCustomerName, currentCustomer.getUid(), null, currentCustomerLogo, currentCustomerLocation, currentCustomerAddress),
<<<<<<< HEAD
                            currentCustomer.getUid(),
<<<<<<< HEAD
                            Status.NEW
<<<<<<< HEAD
=======
                            new Customer(currentCustomerName, currentCustomer.getUid(), null, currentCustomerLogo, currentCustomerLocation, currentCustomerAddress)
>>>>>>> 1036a9d... Fix set logo on re-sign-in. Move Customer_ID to Owner
=======
>>>>>>> 338725e... fix
=======
=======
>>>>>>> 2b9ce43... Fix Role. Fix Task
                            TaskStatus.NEW
>>>>>>> 1e1bfe8... Add status NEW when creating tasks. Add ItemDecorator to tasks recyclerview. Fix margins. Add task random title and body
                    );

                    TaskApp.getInstance().setTaskList(currentTask);

                    hideKeyboard();
                    showProgress();
                    FirebaseDatabase.getInstance().getReference().child(FirebaseReferences.TASKS).child(taskId).setValue(currentTask).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            hideProgress();
                        }
                    });

                    finish();
<<<<<<< HEAD
=======
//                    startActivity(new Intent(CreateTaskActivity.this, MainActivity.class)
//                            .setFlags(FLAG_ACTIVITY_CLEAR_TASK | FLAG_ACTIVITY_NEW_TASK));
>>>>>>> 31724dd... Fix SAVE menuitem in BaseMapActivity
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
>>>>>>> aee538b... bugfix
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
                String title = titleField.getText().toString();
                String body = bodyField.getText().toString();
                Customer currentCustomer = TaskApp.getInstance().getCurrentCustomer();
                TaskLatLng currentCustomerLocation = currentCustomer.getLocation();
                String currentCustomerName = currentCustomer.getName();
                String currentCustomerLogo = currentCustomer.getLogo();
                String currentCustomerAddress = currentCustomer.getAddress();

=======
>>>>>>> d95c681... Refactoring activities
=======

>>>>>>> e2b8173... refactor CreateTaskActivity
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

=======
>>>>>>> d00ba80... Implement DatePicker. Implement Category Spinner
=======
//    @NonNull
//    private ValueEventListener setupDBlistener() {
//        return new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                Customer incomingCustomer = dataSnapshot.child("customers").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).getValue(Customer.class);
=======
//    @NonNull
//    private ValueEventListener getCustomerEventListener() {
//        return new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                final Customer incomingCustomer = dataSnapshot.getValue(Customer.class);
>>>>>>> dabb3d3... Implement taskpager fragments
//                TaskApp.getInstance().setCurrentCustomer(incomingCustomer);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
<<<<<<< HEAD
//
//            }
//        };
//    }
=======
    @NonNull
    private ValueEventListener getCustomerEventListener() {
        return new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final Customer incomingCustomer = dataSnapshot.getValue(Customer.class);
                TaskApp.getInstance().setCurrentCustomer(incomingCustomer);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("LOG", "onCancel: " + databaseError);
            }
        };
    }
>>>>>>> 6b47303... multiple login
=======
//                Log.d("LOG", "onCancel: " + databaseError);
//            }
//        };
//    }
>>>>>>> dabb3d3... Implement taskpager fragments

>>>>>>> 1d51cc4... Models refactoring. Check DB data sent OK
=======
>>>>>>> 64f37b7... Add progressBars
    private void setScroll(EditText field, int maxLines) {
        field.setScroller(new Scroller(this));
        field.setMaxLines(maxLines);
        field.setVerticalScrollBarEnabled(true);
        field.setMovementMethod(new ScrollingMovementMethod());
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
    private String getCurrentDateAndTimeFormatted() {
        return new SimpleDateFormat(Constants.DATE_TIME_FORMAT).format(Calendar.getInstance().getTimeInMillis());
    }

    private String getCurrentDateFormatted() {
        return new SimpleDateFormat(Constants.DATE_FORMAT).format(Calendar.getInstance().getTimeInMillis());
    }

    private String getCurrentTimeFormatted() {
        return new SimpleDateFormat(Constants.TIME_FORMAT).format(Calendar.getInstance().getTimeInMillis());
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

    private void showDate(int day, int month, int year) {
        String dueDate = String.valueOf(month) + "/" + day + "/" + year;
        dateField.setText(dueDate);
    }

    private void showTime(int hours, int minutes) {
        String dueTime = String.valueOf(hours) + ":" + minutes;
        timeField.setText(dueTime);
    }

    private String getFullDueDateAndTime() {
        return dateField.getText().toString() + " " + timeField.getText().toString();
=======
=======
>>>>>>> d00ba80... Implement DatePicker. Implement Category Spinner
    private DatabaseReference getDB() {
        return FirebaseDatabase.getInstance().getReference();
    }

<<<<<<< HEAD
<<<<<<< HEAD
    private String getCurrentTimeFormatted() {
        final String DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";
        return new SimpleDateFormat(DATE_FORMAT).format(Calendar.getInstance().getTimeInMillis());
>>>>>>> d184d09... Task creation and DB saving added
=======
    private String getCurrentTimeFormatted(String format) {
        return new SimpleDateFormat(format).format(Calendar.getInstance().getTimeInMillis());
>>>>>>> ce4de03... Add handler for pause
=======
=======
>>>>>>> 9246afa... fix creating and sending task
    private String getCurrentDateAndTimeFormatted() {
        return new SimpleDateFormat(Constants.DATE_TIME_FORMAT).format(Calendar.getInstance().getTimeInMillis());
    }

    private String getCurrentDateFormatted() {
        return new SimpleDateFormat(Constants.DATE_FORMAT).format(Calendar.getInstance().getTimeInMillis());
    }

    private String getCurrentTimeFormatted() {
<<<<<<< HEAD
        final String DATE_FORMAT = "HH:mm";
        return new SimpleDateFormat(DATE_FORMAT).format(Calendar.getInstance().getTimeInMillis());
>>>>>>> 544cce7... Add Time Picker to CreateActivity
=======
        return new SimpleDateFormat(Constants.TIME_FORMAT).format(Calendar.getInstance().getTimeInMillis());
>>>>>>> 9246afa... fix creating and sending task
    }

=======
>>>>>>> e2b8173... refactor CreateTaskActivity
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
