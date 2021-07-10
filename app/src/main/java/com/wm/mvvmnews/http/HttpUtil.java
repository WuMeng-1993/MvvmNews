package com.wm.mvvmnews.http;

import android.util.Log;

import com.wm.mvvmnews.config.HttpConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author WuMeng
 * @date 2021/7/9
 * desc:
 */
public class HttpUtil {

    private static final String TAG = "WuMeng";

    private static ApiService apiService;

    private static OkHttpClient okHttpClient;

    public static void init() {
        initOkhttp();
        initRetrofit();
    }

    /**
     * 初始化OkHttp
     */
    private static void initOkhttp() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String s) {
                Log.e(TAG,s);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    /**
     * 初始化Retrofit
     */
    private static void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    /**
     * 获取ApiService
     *
     * @return
     */
    public static ApiService getApiService() {
        if (apiService == null) {
            init();
        }
        return apiService;
    }


}
