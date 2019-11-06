package com.fossterer.nutrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        Intent passedIntent = getIntent();

        String date = passedIntent.getIntExtra(MainActivity.CURRENT_DATE, -1000)
                + "/" + passedIntent.getIntExtra(MainActivity.CURRENT_MONTH, -1000)
                + "/" + passedIntent.getIntExtra(MainActivity.CURRENT_YEAR, -1000);


        TextView textView = findViewById(R.id.textView);
        textView.setText(date);
    }
}
