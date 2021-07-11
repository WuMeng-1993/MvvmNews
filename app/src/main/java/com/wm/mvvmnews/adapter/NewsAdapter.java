package com.wm.mvvmnews.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.wm.mvvmnews.R;
import com.wm.mvvmnews.bean.home.NewsBean;
import com.wm.mvvmnews.databinding.LayoutItemNewsBinding;

import java.util.List;

/**
 * @author WuMeng
 * @date 2021/7/10
 * desc:
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolderItem> {

    private List<NewsBean.ResultBean.DataBean> dataBeanList;

    public void setDataBeanList(List<NewsBean.ResultBean.DataBean> dataBeanList) {
        this.dataBeanList = dataBeanList;
        notifyDataSetChanged();
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        LayoutItemNewsBinding itemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.layout_item_news, parent, false);
        return new ViewHolderItem(itemNewsBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull NewsAdapter.ViewHolderItem holder, int position) {
        LayoutItemNewsBinding itemNewsBinding = holder.itemNewsBinding;
        itemNewsBinding.setNews(dataBeanList.get(position));
        itemNewsBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return dataBeanList == null ? 0 : dataBeanList.size();
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder {

        private final LayoutItemNewsBinding itemNewsBinding;

        public ViewHolderItem(@NonNull LayoutItemNewsBinding itemNewsBinding) {
            super(itemNewsBinding.getRoot());
            this.itemNewsBinding = itemNewsBinding;
        }
    }

}
