package com.openld.cloudcake.cityselect;

import com.openld.cloudcake.cityselect.m.beans.CityInfoBean;

import java.util.List;

/**
 * author: lllddd
 * created on: 2021/6/13 10:53
 * description:城市选择约定
 */
public class CitySelectContract {
    /**
     * View约定
     */
    public interface  IView {
    }

    /**
     * Presenter約定
     */
    public interface IPresenter {
        /**
         * 获取城市列表
         *
         * @return 城市信息列表
         */
        List<CityInfoBean> obtainCityList();

        /**
         * 将城市返回给主页面
         *
         * @param city 城市
         */
        void returnCityToMainPage(String city);
    }
}
