package com.openld.cloudcake.main.m;

import com.openld.cloudcake.CloudCakeLink;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author: lllddd
 * created on: 2021/5/23 20:53
 * description:
 */
public class MainModel {
    public void queryWeather(String city, Callback callback) {
        String url = CloudCakeLink.QUERY_WEATHER_BY_CITY + "?city=" + city;
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
