package com.utils.枚举;

import com.utils.开发常用.枚举.EnumDemo;

/**
 * @author: yuanyinhuan
 * @date: 2021/8/17 11:23
 */
public class MainDemo {
    public static void main(String[] args) {

        /** 枚举常量转为字符串, 可用于比较
         * int toString()
         * int name()
         */
        String name1 = EnumDemo.ONE.toString();
        String name2 = EnumDemo.ONE.name();


        /** 返回此枚举常量的序数,初始值从0开始
         * int ordinal()
         */
        int ordinal = EnumDemo.ONE.ordinal();

    }
}
