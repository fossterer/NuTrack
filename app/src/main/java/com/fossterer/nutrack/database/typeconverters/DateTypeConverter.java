package com.fossterer.nutrack.database.typeconverters;

import androidx.room.TypeConverter;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateTypeConverter {
    @TypeConverter
    public static String toString(Date date) {
        return date.toString();
    }

    @TypeConverter
    public static Date toDate(String date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(1, 1, 1);
        return gregorianCalendar.getGregorianChange();
    }
}
