package com.utils.阿里开发规范;

import lombok.Data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class demo01_编程规约 {
    private static final String str = "SEE";

    public static void main(String[] args) {
        Person.test();

        /*纳秒级时间戳*/
        System.out.println(System.nanoTime());
        /*毫秒级时间戳*/
        System.out.println(System.currentTimeMillis());


        /*集合转成map时,出现重复key时对value的处理策略,必须要做,否则会有异常*/
        List<Person<String>> list = new ArrayList<>();
        list.add(new Person<>("yyh", "1234"));
        list.add(new Person<>("yyh", "hainan"));
        list.add(new Person<>("yyh", "guangdong"));


        /*键值对: key:对象的某个属性*/
        Map<String, String> keyToField = list.stream().collect(Collectors.toMap(Person::getName, Person::getAddress, (v1, v2) -> v1));
        /*键值对: key:对象*/
        Map<String, Person<String>> keyToObject = list.stream().collect(Collectors.toMap(Person::getName, Function.identity(), (v1, v2) -> v1));


        /*boolean addAll() 是将其他同类型的集合列表加入进来合并结果集 */
        List<Person<String>> list1 = new ArrayList<>();
        list1.add(new Person<>("yyh", ""));
        list1.add(new Person<>("yyh", "hainan"));
        list1.add(new Person<>("yyh", "guangdong"));
        list1.addAll(list);
        System.out.println(list1);


        /*diamond语法: new的对象类型用<>来指代前面已经定义过的类型*/
        List<Person<String>> diamond = new ArrayList<>(10);
        /*全省略: 将<>也去掉*/
        List<Person<String>> omitAll = new ArrayList(10);


        /*使用entrySet方式遍历Map类集合KV, 而不是keySet*/
        Map<String, List<Person<String>>> map = new HashMap<>(12);
        map.put("1", list);
        map.put("2", list);
        /* map.values() 获取到map的所有key的value集合 map.keySet()返回的是所有的key集合并且是经过去重*/
        Collection<List<Person<String>>> values = map.values();
        Set<String> strings = map.keySet();
        List<List<Person<String>>> list3 = new ArrayList<>(values);
        /* 使用entrySet能够一次比遍历就把key和value都放到entry中,效率更高 */
        for (Map.Entry<String, List<Person<String>>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<Person<String>> value = entry.getValue();
        }
        /* 使用keySet(),使用了两次遍历 第一次是先将key转为Iterator对象,然后再从hashmap取出key对应的value*/
        for (String s : map.keySet()) {
            List<Person<String>> value = map.get(s);
        }
        /* 强烈推荐: Lambda表达式遍历map*/
        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });


        /// 暂时注释的代码，后续可能使用的，使用///注释说明
        //System.out.println("暂停业务逻辑代码");

        //TODO --指代 代办事宜
        //FIXME --指代 错误,不能工作的事


    }

}

@Data
final class Person<T>{
    private T name;
    private String address;

    public Person(T name, String address) {
        this.name = name;
        this.address = address;
    }

    private static final String STR = "123";

    /**
     * 测试TEST
     * @return 返回字符串类型
     */
    public static String test(){
        return "";
    }

}
