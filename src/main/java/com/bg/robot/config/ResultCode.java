package com.bg.robot.config;

/**
 * 定义返回值的枚举类
 */
public enum ResultCode {


    SERVER_SUCCESS(200, "网关服务正常");
    private final int code;

    private final String phrase;

    ResultCode(int value, String phrase) {
        this.code = value;
        this.phrase = phrase;
    }

    public int getCode() {
        return code;
    }

    public String getPhrase() {
        return phrase;
    }
}
