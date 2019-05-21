package com.poni.handle;

import com.poni.domain.Girl;
import com.poni.domain.Result;
import com.poni.exception.GirlException;
import com.poni.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *@author:PONI_CHAN
 *@date:2018/10/4 14:41
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger=LoggerFactory.getLogger(ExceptionHandle.class);

    //声明捕获哪个类，这里是异常类
    @ExceptionHandler(value = Exception.class)
    @ResponseBody  //返回json数据
    public Result handle(Exception e) {
        if (e instanceof GirlException) {   //判断是否是GirlException 的异常
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            logger.error("{系统异常}",e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
