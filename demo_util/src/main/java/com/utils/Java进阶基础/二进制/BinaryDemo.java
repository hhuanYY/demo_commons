package com.utils.Java进阶基础.二进制;

/**
 * @ClassName BinaryDemo
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/9/13 17:49
 * @Version 1.0
 */
public class BinaryDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            System.out.println(Integer.parseInt(Integer.toBinaryString(i)));
        }
    }
}
