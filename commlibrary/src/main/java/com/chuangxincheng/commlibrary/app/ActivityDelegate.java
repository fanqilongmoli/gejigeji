package com.chuangxincheng.commlibrary.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Activity跳转
 * Created by fanqilong on 16/5/28.
 */
public class ActivityDelegate {

    private Context context;
    private Class cls;
    private Bundle bundle;
    private int enterAnim;
    private int exitAnim;

    private ActivityDelegate(Context context) {
        this.context = context;
    }

    /**
     * 跳转activity
     *
     * @param cls 目标activity
     */
    private ActivityDelegate(Class cls) {
        this.cls = cls;
    }

    /**
     * 跳转activity
     *
     * @param cls    目标activity
     * @param bundle 传递的参数
     */
    private ActivityDelegate(Class cls, Bundle bundle) {
        this.cls = cls;
        this.bundle = bundle;
    }

    public static ActivityDelegate create(Context context) {
        return new ActivityDelegate(context);
    }

    public static ActivityDelegate create(Class cls) {
        return new ActivityDelegate(cls);
    }

    public static ActivityDelegate create(Class cls, Bundle bundle) {
        return new ActivityDelegate(cls, bundle);
    }


    public ActivityDelegate transition(int enterAnim, int exitAnim) {
        this.enterAnim = enterAnim;
        this.exitAnim = exitAnim;
        return this;
    }

    public void open(Context context) {
        Intent intent = new Intent(context, cls);
        if (bundle != null && !bundle.isEmpty()) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
        if (context instanceof Activity && enterAnim > 0 && exitAnim > 0) {
            ((Activity) context).overridePendingTransition(enterAnim, exitAnim);
        }
    }

    /**
     * 跳转
     *
     * @param context 当前的上下文
     * @param isKeep  是否保留当前activity
     */
    public void open(Context context, boolean isKeep) {
        Intent intent = new Intent(context, cls);
        if (bundle != null && !bundle.isEmpty()) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
        if (!isKeep && context instanceof Activity) {
            ((Activity) context).finish();
        }
        if (context instanceof Activity && enterAnim > 0 && exitAnim > 0) {
            ((Activity) context).overridePendingTransition(enterAnim, exitAnim);
        }
    }

    public void openForResult(Context context, int requestCode) {
        Intent intent = new Intent(context, cls);
        if (bundle != null && !bundle.isEmpty()) {
            intent.putExtras(bundle);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, requestCode);
        }
        if (context instanceof Activity && enterAnim > 0 && exitAnim > 0) {
            ((Activity) context).overridePendingTransition(enterAnim, exitAnim);
        }
    }

    public void close() {
        if (context != null && context instanceof Activity) {
            Activity activity = (Activity) this.context;
            activity.finish();
            if (enterAnim > 0 && exitAnim > 0) {
                activity.overridePendingTransition(enterAnim, exitAnim);
            }
        }
    }


    public ActivityDelegate putString(String key, String value) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(key, value);
        return this;
    }

    public ActivityDelegate putInt(String key, int value) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt(key, value);
        return this;
    }

    public ActivityDelegate putBoolean(String key, boolean value) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean(key, value);
        return this;
    }

    public ActivityDelegate putAll(String key, Bundle bundle) {
        if (this.bundle == null) {
            this.bundle = new Bundle();
        }
        this.bundle.putAll(bundle);
        return this;
    }


}
