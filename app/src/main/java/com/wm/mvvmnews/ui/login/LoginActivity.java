package com.wm.mvvmnews.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.wm.mvvmnews.ui.MainActivity;
import com.wm.mvvmnews.bean.BaseRequestData;
import com.wm.mvvmnews.bean.login.UserBean;
import com.wm.mvvmnews.config.HttpConfig;
import com.wm.mvvmnews.databinding.ActivityLoginBinding;

/**
 * @author WuMeng
 * @date
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * ViewBinding
     */
    private ActivityLoginBinding loginBinding;

    /**
     * ViewModel
     */
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        loginBinding = ActivityLoginBinding.inflate(LayoutInflater.from(this));
        setContentView(loginBinding.getRoot());
        initClick();
        observe();
    }

    /**
     * 初始化点击事件
     */
    private void initClick() {
        // 点击登录
        loginBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.login(loginBinding.etAccount.getText().toString(),
                        loginBinding.etPass.getText().toString());
            }
        });
    }

    /**
     * 观察
     */
    private void observe() {
        loginViewModel.loginLiveData.observe(this, new Observer<BaseRequestData<UserBean>>() {
            @Override
            public void onChanged(BaseRequestData<UserBean> userBeanBaseRequestData) {
                if (userBeanBaseRequestData.getStatus().equals(HttpConfig.RESULT_OK)) {
                    showToast(userBeanBaseRequestData.getMsg());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    showToast(userBeanBaseRequestData.getMsg());
                }
            }
        });
    }

    /**
     * 显示Toast
     * @param message
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}