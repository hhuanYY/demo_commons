package com.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class DemoUtilApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoUtilApplication.class, args);

//        TestService testService = run.getBean(TestService.class);
//
//        System.err.println("开始执行异步方法: " + Thread.currentThread().getName());
//        testService.test();
//        System.err.println("结束执行异步方法: " + Thread.currentThread().getName());

    }

}
