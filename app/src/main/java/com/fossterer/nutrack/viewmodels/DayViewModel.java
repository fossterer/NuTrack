package com.fossterer.nutrack.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fossterer.nutrack.database.AppDatabase;
import com.fossterer.nutrack.database.entity.Day;

import java.util.Date;

public class DayViewModel extends ViewModel {
    public LiveData<Day> day;

    public LiveData<Day> getDay(Date date) {
        day = AppDatabase.getInstance(this.getApplicationContext()).dayDao().getDay(date);
        return day;
    }
}
