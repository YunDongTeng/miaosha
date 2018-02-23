package com.spark.miaosha.exception;

import com.spark.miaosha.result.Result;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result<String> businessExceptionHandle(BusinessException exception) {
        return new Result<String>(exception.getCodeMsg().getCode(), exception.getCodeMsg().getMsg());
    }

}
