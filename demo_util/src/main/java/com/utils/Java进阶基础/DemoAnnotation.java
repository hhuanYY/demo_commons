package com.utils.Java进阶基础;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Target({ElementType.METHOD,ElementType.METHOD}) 使用大括号支持使用多个类型
 *      标识是用在类上、还是方法上
 * @Retention
 *      什么时候保留注解的存在, 设置值来实现(SOURCE:源代码时保留; CLASS:编译类时保留; RUNTIME:运行时保留)
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DemoAnnotation {
    /**
     * 给自定义注解定义一个字符串类型的value属性, 且默认值为空串
     * @return
     */
    String value() default "";
}
