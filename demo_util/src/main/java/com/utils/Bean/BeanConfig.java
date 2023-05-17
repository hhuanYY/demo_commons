package com.utils.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName BeanConfig
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/13 19:04
 * @Version 1.0
 */
public class BeanConfig {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoBeanConfig.class);

        System.out.println(context.getBean("beanDemo"));

    }
}
