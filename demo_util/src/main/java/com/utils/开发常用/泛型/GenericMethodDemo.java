package com.utils.开发常用.泛型;

import com.sun.org.apache.xpath.internal.operations.String;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenericMethodDemo
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/7 15:26
 * @Version 1.0
 */
@Data
public class GenericMethodDemo {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // 泛型静态方法测试
        GenericPojo genericPojo = genericMethod(GenericPojo.class);
        // 泛型上届测试
        genericMethod02(new ArrayList<Integer>());
        // 泛型下届测试
        genericMethod03(new ArrayList<Object>());
    }

    /**
     * 泛型静态方法
     * @param t
     * @return
     * @param <T>
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static <T> T genericMethod(Class<T> t) throws InstantiationException, IllegalAccessException {
        return t.newInstance();
    }
    /**
     * 泛型上届测试: 问号传入的值必须是extends 后面对象的子类才可编译通过
     * @param list
     * @param <T>
     */
    public static  <T> void genericMethod02(List<? extends Object > list) {
    }

    /**
     * 泛型下届测试: 问号传入的值必须是extends 后面对象的父类才可通过编译
     * @param list
     * @param <T>
     */
    public static  <T> void genericMethod03(List<? super Integer> list) {}


}
