package com.utils;

/**
 * @author: yuanyinhuan
 * @date: 2021/8/24 11:16
 */
public class Str {
    public static void main(String[] args) {
        String str = "http://s3.dossen.com?xxxxxxxxxxi456456";
        int i = str.indexOf("?");
        System.err.println(i);
        String substring = str.substring(0, i);
        System.err.println(substring);

        String s = "202109";
        String substring1 = s.substring(0, 4);
        String substring2 = s.substring(4, 6);
        System.err.println(substring1 + ":" + substring2);


    }
}
