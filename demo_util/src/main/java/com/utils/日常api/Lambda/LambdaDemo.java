package com.utils.日常api.Lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author: yuanyinhuan
 * @date: 2021/9/29 11:27
 */
public class LambdaDemo {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println();
            }
        });
        new Thread(System.err::println);


        // 遍历集合
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        for (Integer i : list) {
            System.err.print(i);
        }

        // Lambda表达式比那里集合
        list.forEach(zz -> System.err.print(zz));





    }

    public static int add(int x, int y) {
        return x + y;
    }
}