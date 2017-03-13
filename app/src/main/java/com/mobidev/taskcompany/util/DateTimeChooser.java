package com.mobidev.taskcompany.util;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by Olga Tolmachenko on 22.02.17.
 */

public class DateTimeChooser {

    private Activity context;
    private TextView timeField;
    private TextView dateField;

    public DateTimeChooser(Activity context, TextView timeField, TextView dateField) {
        this.context = context;
        this.timeField = timeField;
        this.dateField = dateField;
    }

    @NonNull
    public View.OnClickListener setTimeChooserClickListener(final Calendar myCalendar, final TimePickerDialog.OnTimeSetListener time) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(context, time, myCalendar
                        .get(Calendar.HOUR), myCalendar.get(Calendar.MINUTE),
                        true).show();
            }
        };
    }

    @NonNull
    public View.OnClickListener setDateChooserClickListener(final Calendar myCalendar, final DatePickerDialog.OnDateSetListener date) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(context, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        };
    }

    @NonNull
    public TimePickerDialog.OnTimeSetListener getOnTimeSetListener(final Calendar myCalendar) {
        return new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                myCalendar.set(Calendar.HOUR, hourOfDay);
                myCalendar.set(Calendar.MINUTE, minute);
                String time = buildTime(hourOfDay, minute);
                timeField.setText(time);
            }
        };
    }

    @NonNull
    public DatePickerDialog.OnDateSetListener getOnDateSetListener(final Calendar myCalendar) {
        return new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String date = buildDate(dayOfMonth, monthOfYear + 1, year);
                dateField.setText(date);
            }
        };
    }

    private String buildDate(int day, int month, int year) {
        return String.valueOf(month) + "/" + day + "/" + year;
    }

    private String buildTime(int hours, int minutes) {
        return String.valueOf(hours) + ":" + minutes;
    }
}
