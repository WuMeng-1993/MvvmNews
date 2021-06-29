package com.wm.mvvmnews.bean;

/**
 * @author WuMeng
 * @date 2021/6/29
 * desc:
 */
public class BaseRequestData<T> {

    private String status;

    private String msg;

    private T body;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
