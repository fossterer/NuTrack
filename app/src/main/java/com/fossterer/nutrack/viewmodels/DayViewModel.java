package com.fossterer.nutrack.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.fossterer.nutrack.database.AppDatabase;
import com.fossterer.nutrack.database.entity.Day;

import java.util.Date;

public class DayViewModel extends ViewModel {
    public LiveData<Day> day;

    /**
     * Retrieves information related to given data from backend
     *
     * @param date Date at which information is to be retrieved (eg. 07/23/2019)
     * @return day an observable of type 'LiveData<Day>'
     */
    public LiveData<Day> getDay(Context context, Date date) {
        day = AppDatabase.getInstance(context).dayDao().getDay(date);
        return day;
    }
}
