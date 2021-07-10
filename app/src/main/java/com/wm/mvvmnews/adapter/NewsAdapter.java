package com.wm.mvvmnews.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author WuMeng
 * @date 2021/7/10
 * desc:
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolderItem>{

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull NewsAdapter.ViewHolderItem holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder {

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
        }
    }

}
