package com.utils;

/**
 * @author: yuanyinhuan
 * @date: 2022/3/3 17:31
 */
public class Test {
    public static void main(String[] args) throws Exception {

        try {
            String str = "test";
            System.err.println("异常开始");
            str.substring(0, 100);
            System.err.println("异常结束");
        } catch (Exception e) {
            System.err.println("处理异常");
            throw new Exception("下标越界");
        }

        System.err.println("跳出方法");

    }
}
