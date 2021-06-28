package com.wm.mvvmnews;

import android.app.Application;
import android.content.Context;

/**
 * @author WuMeng
 * @date 2021/6/28
 * desc:
 */
public class BaseApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }

}
