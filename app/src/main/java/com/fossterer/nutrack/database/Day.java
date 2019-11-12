package com.fossterer.nutrack.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.json.JSONObject;

import java.util.Date;

/**
 * Main entity class representing the primary aspect of storage in the app - a day's collection of meals
 */
@Entity
public class Day {
    @PrimaryKey
    public Date date;

    public JSONObject meal1;
    public JSONObject meal2;
    public JSONObject meal3;
    public JSONObject meal4;
}
