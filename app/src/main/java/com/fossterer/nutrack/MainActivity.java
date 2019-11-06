package com.fossterer.nutrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static final String CURRENT_DATE = "com.fossterer.nutrack.MainActivity.CURRENT_DATE";
    static final String CURRENT_MONTH = "com.fossterer.nutrack.MainActivity.CURRENT_MONTH";
    static final String CURRENT_YEAR = "com.fossterer.nutrack.MainActivity.CURRENT_YEAR";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String msg = "Date selected is " + dayOfMonth + "/" + (month + 1) + "/" + year;
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

                Intent dayActivityIntent = new Intent(MainActivity.this, DayActivity.class);
                dayActivityIntent.putExtra(CURRENT_DATE, dayOfMonth);
                dayActivityIntent.putExtra(CURRENT_MONTH, (month + 1));
                dayActivityIntent.putExtra(CURRENT_YEAR, year);

                startActivity(dayActivityIntent);
            }
        });
    }
}
