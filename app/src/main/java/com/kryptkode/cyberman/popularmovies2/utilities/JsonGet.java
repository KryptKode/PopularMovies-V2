package com.kryptkode.cyberman.popularmovies2.utilities;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JsonGet {

    private static final String TAG = "JsonGet";

    public static String getPath() {
        return path;
    }

    private static String path;

    private static String trailersPath;
    //method to return JSON data from the URL string passed as parameter
    public static JSONObject getDataFromWeb(String url, int page) {
        path = url + "&page="+ page;
        Log.e("URL", path);
        Response response;
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(path)
                    .build();
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string()); //returns the JSON data
        } catch (IOException | JSONException e) {
            Log.e(TAG, "" + e.getLocalizedMessage());
        }
        return null; //if there is an error, return null
    }

    public static JSONObject getTrailersDataFromWeb(String url, int page) {
        trailersPath = url + "&page="+ page;
        Log.e("URL", trailersPath);
        Response response;
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(trailersPath)
                    .build();
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string()); //returns the JSON data
        } catch (IOException | JSONException e) {
            Log.e(TAG, "" + e.getLocalizedMessage());
        }
        return null; //if there is an error, return null
    }
}