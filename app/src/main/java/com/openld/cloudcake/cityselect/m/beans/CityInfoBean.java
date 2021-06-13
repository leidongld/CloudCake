package com.openld.cloudcake.cityselect.m.beans;

import java.io.Serializable;

/**
 * author: lllddd
 * created on: 2021/6/13 17:13
 * description:
 */
public class CityInfoBean implements Serializable {
    private String cityImageUrl;

    private String city;

    private String cityDesc;

    public String getCityImageUrl() {
        return cityImageUrl;
    }

    public void setCityImageUrl(String cityImageUrl) {
        this.cityImageUrl = cityImageUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityDesc() {
        return cityDesc;
    }

    public void setCityDesc(String cityDesc) {
        this.cityDesc = cityDesc;
    }
}
