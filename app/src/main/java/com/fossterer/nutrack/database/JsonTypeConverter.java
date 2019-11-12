package com.fossterer.nutrack.database;

import androidx.room.TypeConverter;

import org.json.JSONException;
import org.json.JSONObject;

class JsonTypeConverter {

    @TypeConverter
    public String toString(JSONObject jsonObject) {
        return jsonObject.toString();
    }

    @TypeConverter
    public JSONObject toJsonObject(String jsonObject) throws JSONException {
        return new JSONObject(jsonObject);
    }

}
