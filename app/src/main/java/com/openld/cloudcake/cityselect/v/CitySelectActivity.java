package com.openld.cloudcake.cityselect.v;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.openld.cloudcake.R;
import com.openld.cloudcake.cityselect.CitySelectContract;
import com.openld.cloudcake.cityselect.adapters.PagerCityAdapter;
import com.openld.cloudcake.cityselect.m.beans.CityInfoBean;
import com.openld.cloudcake.cityselect.p.CitySelectPresenter;

import java.util.List;

public class CitySelectActivity extends AppCompatActivity implements CitySelectContract.IView, View.OnClickListener, ViewPager.OnPageChangeListener {
    private static final String TAG = "CitySelectActivity";

    private CitySelectContract.IPresenter mPresenter;

    private ViewPager mViewPagerCities;

    private PagerCityAdapter mPagerCityAdapter;

    private FloatingActionButton mBtnTick;

    private String mCurrentCity;

    private List<CityInfoBean> mCityInfoBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_select);

        initWidgets();

        mPresenter = CitySelectPresenter.newInstance(this);
        mCityInfoBeanList = mPresenter.obtainCityList();
        mPagerCityAdapter = new PagerCityAdapter(this, mCityInfoBeanList);
        mViewPagerCities.setAdapter(mPagerCityAdapter);
    }

    /**
     * 初始化控件
     */
    private void initWidgets() {
        mViewPagerCities = findViewById(R.id.view_pager_cities);
        mViewPagerCities.setOffscreenPageLimit(2);
        mViewPagerCities.addOnPageChangeListener(this);

        mBtnTick = findViewById(R.id.btn_tick);
        mBtnTick.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_tick) {
            mPresenter.returnCityToMainPage(mCurrentCity);
            finishAfterTransition();
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (mCityInfoBeanList != null
                && mCityInfoBeanList.size() > position && mCityInfoBeanList.get(position) != null
                && !TextUtils.isEmpty(mCityInfoBeanList.get(position).getCity())) {
            mCurrentCity = mCityInfoBeanList.get(position).getCity();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}