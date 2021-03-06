package com.shallowsmile.projectframwork;

import android.app.Application;

/**
 * 作者： x00090 on 2017/3/1.
 * 邮箱： 986740642@qq.com
 * 类描述：应用Application类用作初始化一些常驻内存的数据
 */

public class ProApplication extends Application {
    private static  ProApplication proApplication;

    /**
     * 获取Application 上下文
     * @return
     */
    public static Application getAppContext(){
        return     proApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        proApplication=this;
    }
}
