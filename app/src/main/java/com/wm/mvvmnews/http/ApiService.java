package com.wm.mvvmnews.http;

import com.wm.mvvmnews.bean.home.NewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author WuMeng
 * @date 2021/7/9
 * desc:
 */
public interface ApiService {

    /**
     * 请求新闻
     * @param type
     * @param key
     * @return
     */
    @GET("toutiao/index")
    Observable<NewsBean> getNews(@Query("type") String type, @Query("key") String key);

}
