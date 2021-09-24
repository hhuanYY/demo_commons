package 每日一练.Lambda分组排序;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: dataStructure 
 * @className: UsetTest
 * @author: yuanyinhuan
 * @description:   
 * @date: 2021/6/15 17:07
 */
public class UsetTest {
    public static void main(String[] args) {
        //存放apple对象集合
        List<Apple> appleList = new ArrayList<>();
        Apple apple1 =  new Apple(1,"柏曼",new BigDecimal("3.25"),2015);
        Apple apple12 = new Apple(1,"城市便捷",new BigDecimal("1.35"),2015);
        Apple apple2 =  new Apple(2,"如家",new BigDecimal("2.89"),2016);
        Apple apple3 =  new Apple(3,"维也纳",new BigDecimal("9.99"),2017);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);


        /**
         * 抽出Apple列表的的Id字段
         */
        List<Integer> collect = appleList.stream().map(Apple::getId).collect(Collectors.toList());
        System.err.println(collect);

        /** 排序:
         * 1. .collect(Collectors.toList()); 表示返回值为当前的列表
         * 2. 添加了Comparator.reverseOrder()则表示降序
         */
        // 按照getMoney字段升序
        List<Apple> collect1 = appleList.stream().sorted(Comparator.comparing(Apple::getMoney)).collect(Collectors.toList());
        // 按照getMoney字段降序 ( 添加了Comparator.reverseOrder()则表示降序 )
        List<Apple> collect2 = appleList.stream().sorted(Comparator.comparing(Apple::getMoney,Comparator.reverseOrder())).collect(Collectors.toList());
        System.err.println(collect1);

        //  使用默认的Collections 实现排序
        Collections.sort(appleList,Comparator.comparing(Apple::getMoney,Comparator.reverseOrder()));
        System.err.println(appleList);


        /** 根据某个字段分组:
         *
         */
        // 单个字段分组
//        Map<String, List<Apple>> collect = appleList.stream().collect(Collectors.groupingBy(Apple::getName));
//        System.err.println(collect);
//        for (Map.Entry<Integer, List<Apple>> entry : collect.entrySet()) {
//            Integer key = entry.getKey();
//            List<Apple> value = entry.getValue();
//            System.err.println(key);
//            System.err.println(value);
//        }

        // 将列表中某个字段提取出来
//        List<Integer> collect1 = appleList.stream().map(Apple::getId).collect(Collectors.toList());
//        System.err.println(collect1);
//
//        Set<Integer> collect2 = appleList.stream().map(Apple::getId).collect(Collectors.toSet());
//        System.err.println(collect2);


    }
}
