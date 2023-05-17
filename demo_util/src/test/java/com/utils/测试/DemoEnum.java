package com.utils.测试;

/**
 * @ClassName demoEnum
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/4/9 13:46
 * @Version 1.0
 */
public enum DemoEnum {
    MONTH("月", "month"),
    YEAR("年","year")
    ;

    private String name;
    private String code;


    DemoEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
