package com.openld.cloudcake;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;

import javax.xml.XMLConstants;

/**
 * author: lllddd
 * created on: 2021/5/23 20:25
 * description:应用类
 */
public class CloudCakeApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context mContext = null;

    @SuppressLint("VisibleForTests")
    @Override
    public void onCreate() {
        super.onCreate();

        if (mContext == null) {
            mContext = getApplicationContext();
        }

        Glide.init(this, new GlideBuilder());
    }

    /**
     * 获取全局Context
     *
     * @return 全局Context
     */
    public static Context getContext() {
        return mContext;
    }
}
