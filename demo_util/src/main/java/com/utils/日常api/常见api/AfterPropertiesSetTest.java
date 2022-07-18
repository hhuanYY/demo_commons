package com.utils.日常api.常见api;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author: yuanyinhuan
 * @date: 2021/12/6 9:30
 * InitializingBean接口的afterPropertiesSet() 进行Bean初始化时执行
 */
@Data
public class AfterPropertiesSetTest implements InitializingBean {

    private String name;
    private Integer age;

    public AfterPropertiesSetTest(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.err.println("执行构造方法");
    }

    public void init() {
        System.err.println("执行init()");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("执行afterPropertiesSet()");
    }
}

