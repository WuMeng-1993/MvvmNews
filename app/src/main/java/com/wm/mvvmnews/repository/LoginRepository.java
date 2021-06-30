package com.wm.mvvmnews.repository;

import androidx.lifecycle.MutableLiveData;

import com.wm.mvvmnews.bean.BaseRequestData;
import com.wm.mvvmnews.bean.login.UserBean;
import com.wm.mvvmnews.config.HttpConfig;
import com.wm.mvvmnews.config.UserConfig;

/**
 * @author WuMeng
 * @date 2021/6/30
 * desc:
 */
public class LoginRepository {

    public static MutableLiveData<BaseRequestData<UserBean>> login(String userName,String pass) {
        BaseRequestData baseRequestData = new BaseRequestData();

        if (userName.equals(UserConfig.USER_NAME) && pass.equals(UserConfig.PASSWORD)) {
            UserBean userBean = new UserBean();
            userBean.setNickName(userName);
            userBean.setPassword(pass);

            baseRequestData.setStatus(HttpConfig.RESULT_OK);
            baseRequestData.setMsg("登录成功");
            baseRequestData.setBody(userBean);
        } else {
            baseRequestData.setMsg("登录失败");
            baseRequestData.setStatus(HttpConfig.REQUEST_FAILED);
        }

        MutableLiveData<BaseRequestData<UserBean>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(baseRequestData);

        return mutableLiveData;
    }

}
