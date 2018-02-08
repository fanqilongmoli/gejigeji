package com.chuangxincheng.commlibrary.app;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * Created by fanqilong on 2016/7/26.
 * Activity 堆栈管理
 */
public class ActivityManager {
    private static Stack<Activity> activityStack;
    private static ActivityManager instance;

    private ActivityManager() {

    }

    /**
     * 单一实例
     */
    public static ActivityManager getAppManager() {
        if (instance == null) {
            instance = new ActivityManager();
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        //防止添加重复的Activity
        Activity currentActivity = currentActivity();
//        if (currentActivity != null) {
//
//            if (activity.getClass().getSimpleName().equals(currentActivity.getClass().getSimpleName())) {
//                activity.finish();
//            } else {
//                activityStack.add(activity);
//            }
//        } else {
        activityStack.add(activity);
//        }
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        if (activityStack != null && activityStack.size() > 0) {
            Activity activity = activityStack.lastElement();
            return activity;
        }
        return null;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 获取指定的Activity
     *
     * @author kymjs
     */
    public static Activity getActivity(Class<?> cls) {
        if (activityStack != null)
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        return null;
    }

    /**
     * 退出应用程序
     */
    public void AppExit(Context context) {

        finishAllActivity();
        // 杀死该应用进程
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(0);
                } catch (Exception e) {

                }

            }
        }).start();
    }

    /**
     * 查找并关闭指定Activity(不确定该Activity是否存在的情况下调用)
     *
     * @param cls
     */
    public void findAndFinishActivity(Class<?> cls) {
        Activity activity = getActivity(cls);
        if (activity != null) {
            finishActivity(activity);
        }
    }

    public boolean hasForegroundActivies() {
        return activityStack.size() != 0;
    }
}
