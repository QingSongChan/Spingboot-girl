package com.poni.utils;

import com.poni.domain.Result;

/*
 *@author:PONI_CHAN
 *@date:2018/10/4 0:39
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("传入成功！");
        result.setData(object);
        return result;
    }

    public static Result success(){
         return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
