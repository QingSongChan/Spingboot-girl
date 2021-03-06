package com.poni.domain;

/*
 *@author:PONI_CHAN
 *@date:2018/10/4 0:31
 */
public class Result<T> {

    //最外层的一个对象
    private Integer code;

    private  String msg;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
