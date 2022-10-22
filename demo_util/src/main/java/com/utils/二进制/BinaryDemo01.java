package com.utils.二进制;

/**
 * @ClassName BinaryDemo01
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/10/5 20:14
 * @Version 1.0
 */
public class BinaryDemo01 {
    public static void main(String[] args) {

        /*
         * int类型 右移 >>> 得到不同八位的结果集
         * -6的二进制表示： 11111111 11111111 11111111 11111010
         *                   b1       b2       b3       b4
         */
        int i = -6;
        System.out.println(Integer.toBinaryString(i));

        int b4 = i & 0xff;
        System.out.println(Integer.toBinaryString(b4));

        int b3 = (i >>> 8) & 0xff;
        System.out.println(Integer.toBinaryString(b3));

        int b2 = (i >>> 16) & 0xff;
        System.out.println(Integer.toBinaryString(b3));

        int b1 = (i>>>24) & 0xff;
        System.out.println(Integer.toBinaryString(b1));

        long l = -4;
        System.out.println(Long.toBinaryString(l));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        int c = '中';
        System.out.println(Integer.toBinaryString(c));


        int p = 80;
        System.out.println(81 % 8);
        System.out.println(81 & 5);


    }
}
