package com.utils.开发常用.集合相关;

import java.util.*;

/**
 * @author: yuanyinhuan
 * @date: 2022/2/21 9:40
 */
public class 遍历Map的几种方式 {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>(16);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        /**方案一:根据map.keyset()得到所有的key,再根据key拿到对应的value*/
//        for (String key : map.keySet()) {
//            System.err.println(key + ":" + map.get(key));
//        }

        /**方案二:通过map.entrySet()使用迭代器iterator遍历key和value*/
//        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, Integer> next = iterator.next();
//            String key = next.getKey();
//            Integer value = next.getValue();
//            System.err.println(key + ":" + value);
//        }

        /**方案三:直接遍历,通过map.entrySet*/
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.err.println(key + ":" + value);
        }

        /**方案四:通过map.values()变量所有的value值,无法遍历key*/
        for (Integer value : map.values()) {
            System.err.println(value);
        }


    }

}
