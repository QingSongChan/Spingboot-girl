package com.poni.enums;

/*
 *@author:PONI_CHAN
 *@date:2018/10/4 15:23
 */
public enum ResultEnum {   //写枚举方法统一维护，方便管理
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你还在上小学"),
    MIDDLE_SCHOOL(101,"你还在上中学"),
    SOCIAL_SCHOOL(102,"你已经步入了社会")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
