package com.fossterer.nutrack;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.GregorianCalendar;

public class DayActivity extends AppCompatActivity {

    private static final String TAG = "DayActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        Intent passedIntent = getIntent();
        int year = passedIntent.getIntExtra(MainActivity.CURRENT_YEAR, -1000);
        int month = passedIntent.getIntExtra(MainActivity.CURRENT_MONTH, -1000);
        int date = passedIntent.getIntExtra(MainActivity.CURRENT_DATE, -1000);

        setHeader(year, month, date);
        showEntries(year, month, date);
    }

    private void setHeader(int year, int month, int date) {
        String day = year + "/" + month + "/" + date;


        TextView textView = findViewById(R.id.textView);
        textView.setText(day);
    }

    private void showEntries(int year, int month, int date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(year, month, date);

        Log.d(TAG, gregorianCalendar.getTime().toString());
    }

}
