package com.openld.cloudcake.main.v;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.openld.cloudcake.CloudCakeApplication;
import com.openld.cloudcake.R;
import com.openld.cloudcake.WeatherIconFactory;
import com.openld.cloudcake.WindIconFactory;
import com.openld.cloudcake.main.m.beans.CityWeatherBean;
import com.openld.cloudcake.cityselect.CitySelectConstants;
import com.openld.cloudcake.main.MainContract;
import com.openld.cloudcake.main.adapters.FutureWeatherAdapter;
import com.openld.cloudcake.main.p.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.IView {
    private static final String TAG = "MainActivity";

    // 城市选择的请求码
    private static final int REQUEST_CODE_FOR_CITY_SELECT = 1 << 1;

    private MainContract.IPresenter mPresenter;

    private TextView mTxtCity;

    private ImageView mImgCity;

    private TextView mTxtDate;

    private ImageView mImgTodayWeather;

    private TextView mTxtCurrentTemperature;

    private TextView mTxtTodayMaxTemperature;

    private TextView mTxtTodayMinTemperature;

    private ImageView mImgWindOrientation;

    private TextView mTxtWindLevel;

    private RecyclerView mRcvFutureDays;

    private FutureWeatherAdapter mFutureWeatherAdapter;

    private String mCurrentCity = "上海";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter = MainPresenter.newInstance(this);

        initWidgets();

        mPresenter.queryWeather(mCurrentCity);
    }

    private void initWidgets() {
        // 初始化城市与日期卡片
        initCityAndDateCardWidgets();

        // 初始化今天
        initTodayWidgets();

        // 初始化昨天部分
        initYesterdayWidgets();

        // 初始化未来部分
        initFutureWidgets();
    }

    /**
     * 初始化未来
     */
    private void initFutureWidgets() {
        mRcvFutureDays = findViewById(R.id.rcv_future_days);
    }

    /**
     * 初始化昨天部分
     */
    private void initYesterdayWidgets() {
        // 前一天的天气没人关心，暂时不做处理
    }

    /**
     * 初始化今天部分
     */
    private void initTodayWidgets() {
        mImgTodayWeather = findViewById(R.id.img_today_weather);
        mTxtCurrentTemperature = findViewById(R.id.txt_show_current_temperature);
        mTxtTodayMaxTemperature = findViewById(R.id.txt_show_max_temperature);
        mTxtTodayMinTemperature = findViewById(R.id.txt_show_min_temperature);
        mImgWindOrientation = findViewById(R.id.img_wind_orientation);
        mTxtWindLevel = findViewById(R.id.txt_wind_level);
    }

    /**
     * 初始化城市与日期卡片
     */
    private void initCityAndDateCardWidgets() {
        mTxtCity = findViewById(R.id.txt_current_city);
        mImgCity = findViewById(R.id.img_city);
        mTxtDate = findViewById(R.id.txt_current_date);
    }


    @Override
    public void showFailToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void updateTodayDetail(CityWeatherBean.DataDTO.ForecastDTO todayBean, String temperature) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTxtCurrentTemperature.setText(temperature + "℃");
                mTxtTodayMaxTemperature.setText(todayBean.high);
                mTxtTodayMinTemperature.setText(todayBean.low);
                mImgTodayWeather.setImageDrawable(getResources().getDrawable(WeatherIconFactory.calculateWeatherIcon(todayBean.type)));
                mImgWindOrientation.setImageDrawable(getResources().getDrawable(WindIconFactory.calculateWindIcon(todayBean.fengxiang)));
                mTxtWindLevel.setText(todayBean.fengli);
            }
        });
        Log.d(TAG, "更新完成今天天气细节");
    }

    @Override
    public void updateCityAndDate(String city, String tips, String time) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mTxtCity.setText(city);
                mTxtDate.setText(time);
                Glide.with(MainActivity.this).load("https://images.pexels.com/photos/131634/pexels-photo-131634.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500").into(mImgCity);
            }
        });
        Log.d(TAG, "更新完成城市与日期");
    }

    @Override
    public void updateYesterdayDetail(CityWeatherBean.DataDTO.YesterdayDTO yesterdayBean) {
        // 昨天的天气没人关心，暂时不做处理
    }

    @Override
    public void updateFutureDetail(@NonNull List<CityWeatherBean.DataDTO.ForecastDTO> forecastDTOList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mFutureWeatherAdapter = new FutureWeatherAdapter(forecastDTOList);
                LinearLayoutManager layoutManager = new LinearLayoutManager(CloudCakeApplication.getContext(), RecyclerView.VERTICAL, false) {
                    @Override
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                mRcvFutureDays.setLayoutManager(layoutManager);
                mRcvFutureDays.setAdapter(mFutureWeatherAdapter);
                mRcvFutureDays.addItemDecoration(new DividerItemDecoration(MainActivity.this, RecyclerView.VERTICAL));
            }
        });
    }

    /**
     * 点击了城市切换
     *
     * @param view 城市展示TextView
     */
    public void onClickCity(View view) {
        mPresenter.jumpToCitySelectPage(REQUEST_CODE_FOR_CITY_SELECT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_FOR_CITY_SELECT && resultCode == RESULT_OK) {
            mCurrentCity = data.getStringExtra(CitySelectConstants.Params.CITY);
            if (TextUtils.isEmpty(mCurrentCity)) {
                mPresenter.queryWeather("上海");
            } else {
                mPresenter.queryWeather(mCurrentCity);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.release();
    }
}