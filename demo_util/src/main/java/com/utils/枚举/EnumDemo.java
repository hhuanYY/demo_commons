package com.utils.枚举;

/**
 * @author: yuanyinhuan
 * @date: 2021/8/17 11:22
 */
public enum EnumDemo {

    ONE,TWO,

    GET("GET请求","GET"),
    POST("POST请求", "POST");

    private String name;
    private String code;

    EnumDemo() {
    }

    EnumDemo(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
