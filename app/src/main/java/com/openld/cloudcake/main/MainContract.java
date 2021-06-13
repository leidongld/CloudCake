package com.openld.cloudcake.main;

import androidx.annotation.NonNull;

import com.openld.cloudcake.beans.CityWeatherBean;

import java.util.Date;
import java.util.List;

/**
 * author: lllddd
 * created on: 2021/5/23 20:48
 * description:
 */
public class MainContract {
    /**
     * View接口
     */
    public interface IView {

        /**
         * 展示失败的吐司
         *
         * @param s 失败详情
         */
        void showFailToast(String s);

        /**
         * 更新今天的天气数据
         *
         * @param todayBean   今天的天气数据
         * @param temperature 当前温度
         */
        void updateTodayDetail(CityWeatherBean.DataDTO.ForecastDTO todayBean, String temperature);

        /**
         * 更新城市、时间、提示
         *
         * @param city 城市
         * @param tips 提示
         * @param time 日期
         */
        void updateCityAndDate(String city, String tips, String time);

        /**
         * 更新昨天天气数据
         *
         * @param yesterdayBean 昨天天气数据
         */
        void updateYesterdayDetail(CityWeatherBean.DataDTO.YesterdayDTO yesterdayBean);

        /**
         * 更新未来的天气数据
         *
         * @param forecastDTOList 未来几天的天气数据
         */
        void updateFutureDetail(@NonNull List<CityWeatherBean.DataDTO.ForecastDTO> forecastDTOList);
    }

    /**
     * Presenter接口
     */
    public interface IPresenter {
        /**
         * 查询天气
         *
         * @param city 城市
         */
        void queryWeather(String city);

        /**
         * 跳转到城市选择页面
         *
         * @param requestCode 请求码
         */
        void jumpToCitySelectPage(int requestCode);


        /**
         * 释放
         */
        void release();
    }
}
