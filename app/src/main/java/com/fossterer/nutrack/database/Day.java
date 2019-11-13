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

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    public JSONObject getMeal1() {
        return meal1;
    }

    public void setMeal1(JSONObject meal1) {
        this.meal1 = meal1;
    }

    public JSONObject getMeal2() {
        return meal2;
    }

    public void setMeal2(JSONObject meal2) {
        this.meal2 = meal2;
    }

    public JSONObject getMeal3() {
        return meal3;
    }

    public void setMeal3(JSONObject meal3) {
        this.meal3 = meal3;
    }

    public JSONObject getMeal4() {
        return meal4;
    }

    public void setMeal4(JSONObject meal4) {
        this.meal4 = meal4;
    }
}
