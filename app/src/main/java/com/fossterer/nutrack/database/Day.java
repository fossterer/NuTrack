package com.fossterer.nutrack.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.fossterer.nutrack.DateTypeConverter;

import org.json.JSONObject;

import java.util.Date;

/**
 * Main entity class representing the primary aspect of storage in the app - a day's collection of meals
 */
@Entity
public class Day {
    @PrimaryKey
    @NonNull
    @TypeConverters(DateTypeConverter.class)
    public Date date;

    @TypeConverters(JsonTypeConverter.class)
    public JSONObject meal1;

    @TypeConverters(JsonTypeConverter.class)
    public JSONObject meal2;

    @TypeConverters(JsonTypeConverter.class)
    public JSONObject meal3;

    @TypeConverters(JsonTypeConverter.class)
    public JSONObject meal4;
}
