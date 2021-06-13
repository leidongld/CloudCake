package com.openld.cloudcake;

/**
 * author: lllddd
 * created on: 2021/6/6 21:42
 * description:
 */
public class WindIconFactory {
    private WindIconFactory() {

    }

    /**
     * 分析出风向图标
     *
     * @param fengxiang 风向
     * @return 风向图标
     */
    public static int calculateWindIcon(String fengxiang) {
        return R.drawable.wind_icon;
    }


}
