package com.utils.开发常用.泛型;

/**
 * @ClassName GenericClassDemo
 * @Description 泛型类 -> 实现泛型接口 (如果实现的泛型接口中传入的仍是形参,则在类名上也必须加上形参<T> )
 * @Author yyhuan
 * @Date 2022/8/7 15:20
 * @Version 1.0
 */
public class GenericClassDemo<GenericPojo> implements GenericInterfaceDemo<GenericPojo> {
    @Override
    public void genericMethod01(GenericPojo genericPojo) {

    }

    @Override
    public GenericPojo genericMethod02() {
        return null;
    }

    @Override
    public GenericPojo genericMethod03(GenericPojo genericPojo) {
        return null;
    }
}
