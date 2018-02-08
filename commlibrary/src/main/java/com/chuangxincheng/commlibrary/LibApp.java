package com.chuangxincheng.commlibrary;

import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.vondear.rxtools.RxTool;

/**
 * Created by fanqilong on 2017/7/20.
 */

/**
 * commlibrary库初始化
 */
public class LibApp {

    private static Context context;

    public LibApp() {

    }

    /**
     * 初始化依赖包,否则会抛出异常
     *
     * @param ctx 主工程的getApplicationContext()
     */
    public static synchronized void init(Context ctx) {
        context = ctx;

        Logger.addLogAdapter(new AndroidLogAdapter());

        RxTool.init(ctx);
    }

    public static Context getContext() {
        if (context == null) {
            throw new ExceptionInInitializerError("Please first initialize in Application");
        }

        return context;
    }
}
