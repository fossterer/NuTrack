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
    public JSONObject toJsonObject(String jsonObject){
        JSONObject jObject = null;
        try {
            jObject = new JSONObject(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jObject;
    }

}
