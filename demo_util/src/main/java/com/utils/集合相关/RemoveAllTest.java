package com.utils.集合相关;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuanyinhuan
 * @date: 2022/3/3 10:05
 */
public class RemoveAllTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");

        /**
         * List.removeAll()方法用于移除指定 collection(list2)中包含的所有元素
         *  例如: list1[1,2,3,4] ; list2[1,2,3]
         *  执行 list1.removeAll(list2)后,list1中仅剩下[4]
         */
        list1.removeAll(list2);

        System.err.println(list1);
        System.err.println(list2);
    }
}
