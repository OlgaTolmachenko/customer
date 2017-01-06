package com.mobidev.taskcompany.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Olga Tolmachenko on 22.02.17.
 */

public class CurrentDateAndTimeFormatUtil {

    public static String getCurrentDateAndTimeFormatted() {
        return new SimpleDateFormat(Constants.DATE_TIME_FORMAT).format(Calendar.getInstance().getTimeInMillis());
    }

    public static String getCurrentDateFormatted() {
        return new SimpleDateFormat(Constants.DATE_FORMAT).format(Calendar.getInstance().getTimeInMillis());
    }

    public static String getCurrentTimeFormatted() {
        return new SimpleDateFormat(Constants.TIME_FORMAT).format(Calendar.getInstance().getTimeInMillis());
    }
}
