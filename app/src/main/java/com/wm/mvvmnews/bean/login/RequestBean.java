package com.wm.mvvmnews.bean.login;

/**
 * @author WuMeng
 * @date 2021/6/29
 * desc:
 */
public class RequestBean {

    private String name;

    private String pass;

    public RequestBean() {
    }

    public RequestBean(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
