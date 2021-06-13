package com.openld.cloudcake.beans;

import java.io.Serializable;
import java.util.List;

/**
 * author: lllddd
 * created on: 2021/5/23 22:04
 * description:
 */
public class CityWeatherBean implements Serializable {
    public DataDTO data;
    public Integer status;
    public String desc;

    public static class DataDTO implements Serializable {
        public DataDTO.YesterdayDTO yesterday;

        public String city;

        public List<ForecastDTO> forecast;

        public String ganmao;

        public String wendu;

        public static class YesterdayDTO implements Serializable {
            public String date;

            public String high;

            public String fx;

            public String low;

            public String fl;

            public String type;
        }

        public static class ForecastDTO implements Serializable {
            public String date;

            public String high;

            public String fengli;

            public String low;

            public String fengxiang;

            public String type;
        }
    }
}
