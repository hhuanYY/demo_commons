package com.utils.开发常用.递归;

import jdk.nashorn.internal.ir.CallNode;

/**
 * 递归三大步骤
 * 1. 定义递归方法的含义
 * 2. 结束递归的标准
 * 3. 寻找等价表达式
 */
public class RecursionDemo {
    public static void main(String[] args) {
        /*递归方法实现100以内的加法*/
        int i = additionOneHundredByRecursion(100);
        System.out.println(i);

        int fibonacciByRecursion = fibonacciByRecursion(10);
        System.out.println(fibonacciByRecursion);

    }

    /**
     * 递归求累加
     * @param num 第n项
     * @return 累计值
     */
    private static int additionOneHundredByRecursion(int num) {

        if (num <= 0) {
            return 0;
        } else {
            return num + additionOneHundredByRecursion(num - 1);
        }
    }

    /**
     * 斐波那契数列
     * @param num 第几项
     * @return 第n项返回值
     */
    private static int fibonacciByRecursion(int num) {

        if (num <= 1) {
            return num;
        }
        return fibonacciByRecursion(num - 1) + fibonacciByRecursion(num - 2);
    }

}
