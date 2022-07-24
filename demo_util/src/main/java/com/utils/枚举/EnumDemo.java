package com.utils.枚举;

/**
 * @author: yuanyinhuan
 * @date: 2021/8/17 11:22
 */
public enum EnumDemo {
    ONE,TWO,THREE,FOUR,FIVE, SIX,

    SUCCESS(200, "请求成功");

    private Integer code;
    private String message;

    EnumDemo() {
    }

    EnumDemo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
