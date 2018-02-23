package com.spark.miaosha.exception;

import com.spark.miaosha.result.CodeMsg;

/**
 * Created by admin on 2018/1/18.
 */
public class BusinessException extends RuntimeException {

    private CodeMsg codeMsg;

    public BusinessException(String errorCode, String errorMsg) {
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }
}
