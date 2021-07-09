package com.wm.mvvmnews.http;

import com.wm.mvvmnews.config.HttpConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author WuMeng
 * @date 2021/7/9
 * desc:
 */
public class HttpUtil {

    private static ApiService apiService;

    public static void init() {
        initRetrofit();
    }

    /**
     * 初始化Retrofit
     */
    private static void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    /**
     * 获取ApiService
     * @return
     */
    public static ApiService getApiService() {
        if (apiService == null) {
            init();
        }
        return apiService;
    }



}
