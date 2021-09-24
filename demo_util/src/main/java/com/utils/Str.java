package com.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuanyinhuan
 * @date: 2021/8/24 11:16
 */
public class Str {
    public static void main(String[] args) {
//        String str = "http://s3.dossen.com?xxxxxxxxxxi456456";
//        int i = str.indexOf("?");
//        System.err.println(i);
//        String substring = str.substring(0, i);
//        System.err.println(substring);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("2");
        list.add("5");

        String s = list.get(list.size()-1);
        System.err.println(s);


    }
}
