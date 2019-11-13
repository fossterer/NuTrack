package com.fossterer.nutrack;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fossterer.nutrack.database.AppDatabase;
import com.fossterer.nutrack.database.entity.Day;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DayActivity extends AppCompatActivity {

    private static final String TAG = "DayActivity";

    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        Intent passedIntent = getIntent();
        GregorianCalendar gregorianCalendar = (GregorianCalendar) passedIntent.getSerializableExtra(MainActivity.DATE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        // TODO: Avoid concatenation. Use resource string with placeholders
        String str = (gregorianCalendar.get(Calendar.MONTH) + 1) + "/" + Calendar.DAY_OF_MONTH + "/" + gregorianCalendar.get(Calendar.YEAR);
        try {
            date = simpleDateFormat.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setHeader(date);
        showEntries(date);
    }

    private void setHeader(Date date) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(date.toString());
    }

    private void showEntries(Date date) {
        Log.d(TAG, date.toString());
        // Get reference to meal_1 resource
        TextView meal1_view = findViewById(R.id.meal1_item1);
        // Get meal_1 JSON from database for row with date from gregorianCalendar
        try {
            Day day = AppDatabase.getInstance(this.getApplicationContext()).dayDao().getDay(date);
            // setText for the meal_1 resource
            meal1_view.setText(day.getMeal1().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
