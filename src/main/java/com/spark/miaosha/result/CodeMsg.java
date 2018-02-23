package com.spark.miaosha.result;

public class CodeMsg {

    private int code;
    private String msg;

    /**
     * 疑问1：使用静态内部类和使用枚举的效率问题
     */


    //成功
    public static CodeMsg SUCCESS = new CodeMsg(200, "success");

    //服务器异常
    public static CodeMsg SERVER_ERROR = new CodeMsg(500, "server error");

    //订单异常
    public static CodeMsg ORDER_ERROR = new CodeMsg(500100, "order error");

    //秒杀异常
    public static CodeMsg MIAOSHA_ERROR = new CodeMsg(500200, "miaosha error");

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
