package com.bg.robot.rest.dto;

/**
 * Created by wangpeng on 15/09/2017.
 */
public class ResultDTO {


    private boolean success;

    private String message;

    private Object result;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
