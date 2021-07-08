package com.wm.mvvmnews.ui.home;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.wm.mvvmnews.bean.home.NewsBean;

/**
 * @author WuMeng
 * @date 2021/7/8
 * desc:
 */
public class HomeViewModel extends ViewModel {

    private String appKey;

    public HomeViewModel(String appKey) {
        this.appKey = appKey;
    }

    private MutableLiveData<String> newsType = new MutableLiveData<>();

    public void getNews(String type) {
        newsType.setValue(type);
    }

    public LiveData<NewsBean> newsLiveData = Transformations.switchMap(newsType, new Function<String, LiveData<NewsBean>>() {
        @Override
        public LiveData<NewsBean> apply(String input) {
            return null;
        }
    });


}
