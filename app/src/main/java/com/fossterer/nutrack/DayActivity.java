package com.fossterer.nutrack;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.fossterer.nutrack.viewmodels.DayViewModel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DayActivity extends AppCompatActivity {

    private static final String TAG = "DayActivity";

    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        Intent passedIntent = getIntent();
        GregorianCalendar gregorianCalendar = (GregorianCalendar) passedIntent.getSerializableExtra(MainActivity.DATE);

        String dateString = String.format(Locale.getDefault(), "%d/%d/%d", gregorianCalendar.get(Calendar.MONTH) + 1, gregorianCalendar.get(Calendar.DAY_OF_MONTH), gregorianCalendar.get(Calendar.YEAR));

        setHeader(dateString);
        showEntries(gregorianCalendar.getTime());
    }

    private void setHeader(String str) {
        TextView textView = findViewById(R.id.textView);
        textView.setText(str);
    }

    /**
     * Fills UI elements with values read from database
     * <p>
     * Subscribes to DayViewModel for database operations
     *
     * @param date Date at which information is to be retrieved (eg. 07/23/2019)
     */
    private void showEntries(Date date) {
        Log.d(TAG, date.toString());
        // Get reference to meal_1 resource
        TextView meal1_view = findViewById(R.id.meal1_item1);
        // Get meal_1 JSON from database for row with date from gregorianCalendar
        try {
            DayViewModel dayViewModel = ViewModelProviders.of(this).get(DayViewModel.class);
            dayViewModel.getDay(this.getApplicationContext(), date).observe(this, day -> {
                if (day != null) {
                    meal1_view.setText(day.getMeal1().toString());
                }
            });
            // setText for the meal_1 resource
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
