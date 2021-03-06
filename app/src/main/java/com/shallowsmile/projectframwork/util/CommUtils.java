package com.shallowsmile.projectframwork.util;

import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * 作者： x00090 on 2017/3/1.
 * 邮箱： 986740642@qq.com
 * 类描述：通用工具类
 */

public class CommUtils {
    /**
     * 获得设备的最小宽度DP
     *
     * @param manager
     * @return
     */
    public static int getDeviceSwDpi(WindowManager manager) {
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        int sWidth = Math.min(dm.heightPixels, dm.widthPixels);
        return (int) (sWidth / dm.density);
    }

    public static int getDeviceWHRate(WindowManager manager) {
        //返回1  表示3/4 返回2拜师 9/16
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        float wh = (float) Math.max(dm.heightPixels, dm.widthPixels) / (float) Math.min(dm.heightPixels, dm.widthPixels);
        return (Math.abs(wh - 1.33)) > Math.abs(wh - 1.77) ? 2 : 1;

    }

    /**
     * 获取设备最小宽度像素
     * @param manager
     * @param rate
     * @return
     */
    public static int getDeviceSwPx(WindowManager manager, float rate) {
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        return (int) ((Math.max(dm.heightPixels, dm.widthPixels) - Math.min(dm.heightPixels, dm.widthPixels) * rate) / 2);
    }
}
