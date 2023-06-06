package com.utils;

import cn.hutool.extra.spring.SpringUtil;
import com.utils.Bean.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;
import java.util.stream.Collectors;

//@EnableAsync
@SpringBootApplication
@ServletComponentScan("com.utils.*")
public class DemoUtilApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoUtilApplication.class, args);
        System.out.println("开启启动..."+ Thread.currentThread().getName());

        Map<String, DemoService> hashMap= SpringUtil.getBeansOfType(DemoService.class);
        System.out.println(hashMap);

        hashMap.keySet().stream().filter(String::isEmpty).collect(Collectors.toList());


//        TestService testService = run.getBean(TestService.class);
//
//        System.err.println("开始执行异步方法: " + Thread.currentThread().getName());
//        testService.test();
//        System.err.println("结束执行异步方法: " + Thread.currentThread().getName());

    }

}
