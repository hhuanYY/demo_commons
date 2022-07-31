package com.utils.Java进阶基础.反射;

import lombok.Data;

@Data
public class Ref {
    private String password;
    private Integer sign;
    private String md5(String password, String sign) {
        this.password = password + sign;
        return password + sign;
    }
}
