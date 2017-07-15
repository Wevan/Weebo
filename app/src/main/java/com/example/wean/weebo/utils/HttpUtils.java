package com.example.wean.weebo.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Wean on 2017/7/9.
 */

public class HttpUtils {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
