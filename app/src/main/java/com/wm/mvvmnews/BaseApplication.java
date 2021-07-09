package com.wm.mvvmnews;

import android.app.Application;
import android.content.Context;

import com.wm.mvvmnews.http.HttpUtil;

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
        HttpUtil.init();
    }

    public static Context getContext() {
        return mContext;
    }

}
