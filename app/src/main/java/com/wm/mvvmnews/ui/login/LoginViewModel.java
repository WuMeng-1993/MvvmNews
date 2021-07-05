package com.wm.mvvmnews.ui.login;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.wm.mvvmnews.bean.BaseRequestData;
import com.wm.mvvmnews.bean.login.RequestBean;
import com.wm.mvvmnews.bean.login.UserBean;
import com.wm.mvvmnews.repository.LoginRepository;

/**
 * @author WuMeng
 * @date 2021/6/28
 * desc:
 */
public class LoginViewModel extends ViewModel {

    private MutableLiveData<RequestBean> requestBeanLiveData = new MutableLiveData<>();

    public LiveData<BaseRequestData<UserBean>> loginLiveData = Transformations.switchMap(requestBeanLiveData,
            new Function<RequestBean, LiveData<BaseRequestData<UserBean>>>() {
                @Override
                public LiveData<BaseRequestData<UserBean>> apply(RequestBean input) {
                    return LoginRepository.login(input.getName(), input.getPass());
                }
            });

    /**
     * 登录
     *
     * @param name
     * @param pass
     */
    public void login(String name, String pass) {
        RequestBean bean = new RequestBean(name, pass);
        requestBeanLiveData.setValue(bean);
    }

}
