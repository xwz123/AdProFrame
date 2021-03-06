package com.shallowsmile.projectframwork.util;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.util.List;

/**
 * 作者： x00090 on 2017/3/1.
 * 邮箱： 986740642@qq.com
 * 类描述：检测App运行状态
 */

public class AppStateUtils {
    /**
     * 判断当前应用是否在后台
     *
     * @param context
     * @return
     */
    public static boolean isBackground(Context context) {
        boolean isInBackground = true;
        try {
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
                List<ActivityManager.RunningAppProcessInfo> runningProcesses = am.getRunningAppProcesses();
                for (ActivityManager.RunningAppProcessInfo processInfo : runningProcesses) {
                    if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                        for (String activeProcess : processInfo.pkgList) {
                            if (activeProcess.equals(context.getPackageName())) {
                                isInBackground = false;
                                //Log.e("前台","shi");
                            }
                        }
                    }
                }
            } else {
                List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);
                ComponentName componentInfo = taskInfo.get(0).topActivity;
                if (componentInfo.getPackageName().equals(context.getPackageName())) {
                    isInBackground = false;
                    // Log.e("前台","shi");
                }
            }
        }catch (Exception e){

        }


        return isInBackground;
    }

    /**
     * 判断应用是否正在运行
     *
     * @param context
     * @param packageName
     * @return
     */
    public static boolean isRunning(Context context, String packageName) {
        boolean isRuning=false;
        try {
            ActivityManager am = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> list = am.getRunningAppProcesses();
            for (ActivityManager.RunningAppProcessInfo appProcess : list) {
                String processName = appProcess.processName;
                if (processName != null && processName.equals(packageName)) {
                    Log.e("d","d");
                    isRuning=true;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isRuning;
    }


    /**
     *
     * 获取当前应用的顶层Activity的名字
     *
     * @param context
     * @return
     */
    public static String getRunTaskTopActivity(Context context,String packageName) {
        String className = "";
        try {
            ActivityManager am = (ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(100);
            for (ActivityManager.RunningTaskInfo appProcess : taskInfo) {
                String processName = appProcess.topActivity.getPackageName();
                if (processName != null && processName.equals(packageName)) {
                    className = appProcess.topActivity.getClassName();
                }
            }
        }catch (Exception e){

        }
        return className;
    }
}
