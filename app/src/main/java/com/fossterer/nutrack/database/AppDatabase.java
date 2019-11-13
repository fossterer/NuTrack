package com.fossterer.nutrack.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.fossterer.nutrack.database.dao.DayDao;
import com.fossterer.nutrack.database.entity.Day;

/**
 * Database holder class for the main database used in this app
 */
@Database(entities = {Day.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    /**
     * Provides access to singleton instance of main database used in the application
     *
     * @param context Context of the invoking class where instance of database is needed
     * @return Singleton instance of AppDatabase
     */
    public static synchronized AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "dayDatabase").build();
        }
        return appDatabase;
    }

    public abstract DayDao dayDao();

}
