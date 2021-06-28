package com.wm.mvvmnews.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.wm.mvvmnews.databinding.ActivityLoginBinding;

/**
 * @author WuMeng
 * @date
 */
public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding loginBinding;

    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginBinding = ActivityLoginBinding.inflate(LayoutInflater.from(this));
        setContentView(loginBinding.getRoot());
        initClick();
    }

    /**
     * 初始化点击事件
     */
    private void initClick() {
        // 点击登录
        loginBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

}