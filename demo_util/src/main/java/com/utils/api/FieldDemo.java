package com.utils.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName FieldDemo
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/10/22 15:28
 * @Version 1.0
 */
@Data
public class FieldDemo {

    // 用于属性上,在序列化时将Java Bean中的属性过滤,序列化和反序列化都收到影响
    @JsonProperty("username")
    private String USER_NAME;

    @JsonProperty("password")
    // 用于属性上,在序列化时将PASSWORD序列化名称为password
    private String PASSWORD;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    // 用于属性上,将Date的字段,序列化为指定格式yyyy-MM-dd
    private Date createTIME;
}
