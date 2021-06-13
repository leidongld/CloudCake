package com.openld.cloudcake;

import android.text.TextUtils;

/**
 * author: lllddd
 * created on: 2021/5/29 13:41
 * description:
 */
public class WeatherIconFactory {
    private WeatherIconFactory() {

    }

    public static int calculateWeatherIcon(String weather) {
        if (TextUtils.isEmpty(weather)) {
            return R.drawable.weather_icon_qing;
        }

        if ("晴".equals(weather)) {
            return R.drawable.weather_icon_qing;
        } else if ("阴".equals(weather)) {
            return R.drawable.weather_icon_yin;
        } else if ("小雨".equals(weather)) {
            return R.drawable.weather_icon_xiaoyu;
        } else if ("中雨".equals(weather)) {
            return R.drawable.weather_icon_zhongyu;
        } else if ("大雨".equals(weather)) {
            return R.drawable.weather_icon_dayu;
        } else if ("暴雨".equals(weather)) {
            return R.drawable.weather_icon_baoyu;
        } else if ("小雪".equals(weather)) {
            return R.drawable.weather_icon_xiaoxue;
        } else if ("中雪".equals(weather)) {
            return R.drawable.weather_icon_zhongxue;
        } else if ("大雪".equals(weather)) {
            return R.drawable.weather_icon_daxue;
        } else if ("暴雪".equals(weather)) {
            return R.drawable.weather_icon_baoxue;
        } else {
            return R.drawable.weather_icon_qing;
        }
    }
}
