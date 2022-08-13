package com.utils.开发常用.泛型;

/**
 * @InterfaceNameGenericInterfaceDemo
 * @Description 泛型接口
 * @Author yyhuan
 * @Date 2022/8/7 15:18
 * @Version 1.0
 */
public interface GenericInterfaceDemo<T> {

    void genericMethod01(T t);

    T genericMethod02();

    T genericMethod03(T t);

}
