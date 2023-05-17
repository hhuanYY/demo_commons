package com.utils.常用工具.输入日志模板;

/**
 * @EnumName DescEnum
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/4/15 21:29
 * @Version 1.0
 */
public enum DescEnum {
    ADD("新增"),
    UPDATE("修改"),
    SELECT("查询"),
    DELETE("删除");

    private String type;

    DescEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
