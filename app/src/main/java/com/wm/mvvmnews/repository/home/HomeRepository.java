package com.wm.mvvmnews.repository.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.wm.mvvmnews.bean.home.NewsBean;
import com.wm.mvvmnews.http.HttpUtil;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author WuMeng
 * @date 2021/7/9
 * desc:
 */
public class HomeRepository {

    public LiveData<NewsBean> getNews(String type,String appKey){
        MutableLiveData<NewsBean> newsLiveData = new MutableLiveData<>();
        HttpUtil.getApiService().getNews(type, appKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        newsLiveData.setValue(newsBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return newsLiveData;
    }

}
