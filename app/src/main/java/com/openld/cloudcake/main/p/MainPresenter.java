package com.openld.cloudcake.main.p;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;

import com.google.gson.Gson;
import com.openld.cloudcake.beans.CityWeatherBean;
import com.openld.cloudcake.cityselect.v.CitySelectActivity;
import com.openld.cloudcake.main.MainContract;
import com.openld.cloudcake.main.m.MainModel;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * author: lllddd
 * created on: 2021/5/23 20:52
 * description:
 */
public class MainPresenter implements MainContract.IPresenter {
    private static MainPresenter mPresenter;

    private final MainModel mModel;

    private final MainContract.IView mView;

    private MainPresenter(MainContract.IView view) {
        this.mView = view;
        this.mModel = new MainModel();
    }

    public static MainPresenter newInstance(MainContract.IView view) {
        if (mPresenter == null) {
            synchronized (MainPresenter.class) {
                if (mPresenter == null) {
                    mPresenter = new MainPresenter(view);
                }
            }
        }
        return mPresenter;
    }

    /**
     * 释放Presenter
     */
    @Override
    public void release() {
        if (mPresenter != null) {
            mPresenter = null;
        }
    }

    @Override
    public void queryWeather(String city) {
        mModel.queryWeather(city, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        mView.showFailToast("查询天气失败\n" + e.getMessage());
                        Looper.loop();
                    }
                }).start();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                assert response.body() != null;
                Gson gson = new Gson();
                CityWeatherBean cityWeatherBean = gson.fromJson(response.body().string(), CityWeatherBean.class);
                if (cityWeatherBean == null || cityWeatherBean.status != 1000) {
                    return;
                }

                Date date = new Date();
                @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
                // 更新城市与日期
                mView.updateCityAndDate(cityWeatherBean.data.city, cityWeatherBean.data.ganmao, simpleDateFormat.format(date));

                List<CityWeatherBean.DataDTO.ForecastDTO> forecastDTOList = cityWeatherBean.data.forecast;
                if (forecastDTOList != null && !forecastDTOList.isEmpty()) {
                    CityWeatherBean.DataDTO.ForecastDTO todayBean = forecastDTOList.get(0);
                    // 更新今天的数据
                    mView.updateTodayDetail(todayBean, cityWeatherBean.data.wendu);

                    if (forecastDTOList.size() > 1) {
                        mView.updateFutureDetail(forecastDTOList.subList(1, forecastDTOList.size()));
                    }
                }

                CityWeatherBean.DataDTO.YesterdayDTO yesterdayDTO = cityWeatherBean.data.yesterday;
                if (yesterdayDTO != null) {
                    // 更新昨天的数据
                    mView.updateYesterdayDetail(yesterdayDTO);
                }
            }
        });
    }

    @Override
    public void jumpToCitySelectPage(int requestCode) {
        Intent intent = new Intent((Context) mView, CitySelectActivity.class);
        ((Activity) mView).startActivityForResult(intent, requestCode, ActivityOptions.makeSceneTransitionAnimation((Activity) mView).toBundle());
    }
}
