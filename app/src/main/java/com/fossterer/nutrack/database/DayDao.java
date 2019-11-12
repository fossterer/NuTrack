package com.fossterer.nutrack.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

/**
 * DAO exposing various database operations needed by the app as Java methods
 */
@Dao
public interface DayDao {
    @Query("SELECT * FROM day")
    List<Day> getAll();

    @Query(("SELECT * FROM day WHERE date = :date"))
    Day getDay(Date date);

    @Insert
    void insertAll(Day... days);

    @Delete
    void delete(Day day);
}
