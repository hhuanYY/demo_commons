package com.utils.日常api.常见api;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: yuanyinhuan
 * @date: 2021/12/6 9:34
 */
public class TestMain {

    @Autowired
    private static AfterPropertiesSetTest afterPropertiesSetTest;

    public static void main(String[] args) {

        AfterPropertiesSetTest yyh = new AfterPropertiesSetTest("YYH", 18);


        System.err.println(yyh);

    }
}
