package com.openld.cloudcake.cityselect.p;

import android.app.Activity;
import android.content.Intent;

import com.openld.cloudcake.cityselect.CitySelectConstants;
import com.openld.cloudcake.cityselect.CitySelectContract;
import com.openld.cloudcake.cityselect.m.CitySelectModel;
import com.openld.cloudcake.cityselect.m.beans.CityInfoBean;
import com.openld.cloudcake.main.p.MainPresenter;

import java.util.List;

/**
 * author: lllddd
 * created on: 2021/6/13 10:59
 * description:城市选择Presenter
 */
public class CitySelectPresenter implements CitySelectContract.IPresenter {
    private CitySelectContract.IView mView;

    private static CitySelectPresenter mPresenter;

    private CitySelectModel mCitySelectModel;

    public CitySelectPresenter(CitySelectContract.IView view) {
        this.mView = view;
        mCitySelectModel = new CitySelectModel();
    }

    public static CitySelectContract.IPresenter newInstance(CitySelectContract.IView view) {
        if (mPresenter == null) {
            synchronized (MainPresenter.class) {
                if (mPresenter == null) {
                    mPresenter = new CitySelectPresenter(view);
                }
            }
        }
        return mPresenter;
    }

    public static void release() {
        if (mPresenter != null) {
            mPresenter = null;
        }
    }

    @Override
    public List<CityInfoBean> obtainCityList() {
        return mCitySelectModel.queryAllCityList();
    }

    @Override
    public void returnCityToMainPage(String city) {
        Intent intent = new Intent();
        intent.putExtra(CitySelectConstants.Params.CITY, city);
        ((Activity) mView).setResult(Activity.RESULT_OK, intent);
    }
}











