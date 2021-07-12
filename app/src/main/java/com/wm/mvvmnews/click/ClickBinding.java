package com.wm.mvvmnews.click;

import android.content.Intent;
import android.view.View;

import com.wm.mvvmnews.bean.home.NewsBean;
import com.wm.mvvmnews.ui.detail.NewsDetailActivity;

/**
 * @author WuMeng
 * @date 2021/7/12
 * desc:
 */
public class ClickBinding {

    public void itemClick(NewsBean.ResultBean.DataBean dataBean, View view) {
        Intent intent = new Intent(view.getContext(), NewsDetailActivity.class);
        intent.putExtra("newsUrl",dataBean.getUrl());
        view.getContext().startActivity(intent);
    }

}
