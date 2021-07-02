package com.bjpowernode.crm.commons.domain;

/**
 * ************
 * 暗月     *********
 * **    *   *
 * **********
 * <p>
 * 2021/6/5
 */
public class ReturnObject {
    private String code;
    private String message;
    Object retDAta;

    @Override
    public String toString() {
        return "ReturnObject{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", retDAta=" + retDAta +
                '}';
    }

    public String getCode() {
        return code;
    }

    public ReturnObject setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ReturnObject setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getRetDAta() {
        return retDAta;
    }

    public ReturnObject setRetDAta(Object retDAta) {
        this.retDAta = retDAta;
        return this;
    }

    public ReturnObject() {
    }

    public ReturnObject(String code, String message, Object retDAta) {
        this.code = code;
        this.message = message;
        this.retDAta = retDAta;
    }
}
