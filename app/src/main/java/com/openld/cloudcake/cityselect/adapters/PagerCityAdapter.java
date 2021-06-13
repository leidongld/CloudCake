package com.openld.cloudcake.cityselect.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.openld.cloudcake.R;
import com.openld.cloudcake.cityselect.m.beans.CityInfoBean;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * author: lllddd
 * created on: 2021/6/13 17:10
 * description:
 */
public class PagerCityAdapter extends PagerAdapter {
    private final Context mContext;
    private final List<CityInfoBean> mCityInfoBeanList;

    public PagerCityAdapter(Context context, List<CityInfoBean> cityInfoBeanList) {
        this.mContext = context;
        this.mCityInfoBeanList = cityInfoBeanList;
    }

    @Override
    public int getCount() {
        return mCityInfoBeanList == null ? 0 : mCityInfoBeanList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view == object;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_pager_city, null);
        ImageView imgCity = view.findViewById(R.id.img_city);
        TextView txtCity = view.findViewById(R.id.txt_city);
        TextView txtCityDesc = view.findViewById(R.id.txt_city_desc);

        CityInfoBean cityInfoBean = mCityInfoBeanList.get(position);
        Glide.with(mContext).load(cityInfoBean.getCityImageUrl()).into(imgCity);
        txtCity.setText(cityInfoBean.getCity());
        txtCityDesc.setText(cityInfoBean.getCityDesc());

        view.setTag(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        container.removeView((View) object);
    }
}
