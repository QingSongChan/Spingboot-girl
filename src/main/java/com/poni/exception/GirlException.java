package com.poni.exception;

import com.poni.enums.ResultEnum;

/*
 *@author:PONI_CHAN
 *@date:2018/10/4 14:55
 */
public class GirlException extends RuntimeException{
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
