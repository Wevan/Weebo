package com.example.wean.weebo.utils;

import com.example.wean.weebo.gson.Statuses;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Wean on 2017/7/9.
 */

public class JsonUtils {


    public static Statuses handleWeatherResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("Statuses");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent, Statuses.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
