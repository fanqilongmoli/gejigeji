package com.chuangxincheng.commlibrary.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 跟App相关的辅助类（厂商，系统，应用，屏幕）----适配关键
 */
public class AppInfoUtil {

    private AppInfoUtil() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    /**
     * 获取应用程序名称
     */
    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取 应用对应的渠道号
     *
     * @param context 上下文对象
     * @return 当前应用对应的渠道号
     */
    public static String getMI_CHANNEL_VALUE(Context context) {
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(),
                    PackageManager.GET_META_DATA);
            return appInfo.metaData.getString("MI_CHANNEL");
            //Log.d("Tag", " app key : " + value);  // Tag﹕ app key : AIzaSyBhBFOgVQclaa8p1JJeqaZHiCo2nfiyBBo
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context 上下文对象
     * @return 当前应用的版本名称
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 判断程序是否在后台运行
     *
     * @param context
     * @return
     */
    public static boolean isBackground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(context.getPackageName())) {
                return appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_BACKGROUND;
            }
        }
        return false;
    }


}
