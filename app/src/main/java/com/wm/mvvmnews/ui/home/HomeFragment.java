package com.wm.mvvmnews.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wm.mvvmnews.R;
import com.wm.mvvmnews.bean.home.NewsBean;

/**
 * @author WuMeng
 * @date 2021/7/7
 * desc:
 */
public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private HomeViewModel mHomeViewModel;

    private String appKey = "04ea095cbea56775e2d1669713f34cc2";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mHomeViewModel = new ViewModelProvider(this,new HomeViewModelFactory(appKey)).get(HomeViewModel.class);
        initView(view);
        addObserver();
    }

    /**
     * 初始化视图
     */
    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
    }

    /**
     * 添加观察者
     */
    private void addObserver() {
        mHomeViewModel.getNews("Top");
        mHomeViewModel.newsLiveData.observe(getViewLifecycleOwner(), new Observer<NewsBean>() {
            @Override
            public void onChanged(NewsBean newsBean) {

            }
        });
    }

}
