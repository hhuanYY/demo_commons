package com.utils.字符串相关;

import com.alibaba.fastjson.JSON;
import com.utils.时间工具.DateTimeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * @author: yuanyinhuan
 * @date: 2021/8/24 11:16
 */
public class Str {

    public static String strTest() {
        return "null";
    }

    public static void main(String[] args) {


        String s = strTest();

        if (StringUtils.isNotBlank(s)) {
            System.err.println("Y");
        } else {
            System.err.println("N");
        }







//        int a = 0;
//        int b = 0;
//        for (int i = 0; i <= 3; i++) {
//            --a;
//            System.err.println(a);
////            System.err.println("初始值: "+a);
////            System.err.println("我是第" + i + "位的a++:" + a++);
////            System.err.println("我是第" + i + "位的++b:" + ++b);
////            System.err.println("-------------------");
//        }



//        String str = "Y";
//        String str1 = "y";
//        if (str.equalsIgnoreCase(str1)) {
//            System.err.println("成功...");
//        }

//        String str12 = "https://dataeye.test.dossen.com/operate/data111111111";
//        String[] coms = str12.split("com");
//        System.err.println(coms[1]);
//
//
//        String st11 = "index_occ";
//        System.err.println(st11.toUpperCase());

//        String str = "http://s3.dossen.com?xxxxxxxxxxi456456";
//        int i = str.indexOf("?");
//        System.err.println(i);
//        String substring = str.substring(0, i);
//        System.err.println(substring);
//
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("2");
//        list.add("2");
//        list.add("2");
//        list.add("5");
//
//        String s = list.get(list.size()-1);
//        System.err.println(s);



//        String str = "[http://10.0.31.7:9000/observatory/Dossen202110GainReport01.png, http://10.0.31.7:9000/observatory/Dossen202110GainReport02.png, http://10.0.31.7:9000/observatory/Dossen202110GainReport03.png, http://10.0.31.7:9000/observatory/Dossen202110GainReport04.png, \n" +
//                "http://10.0.31.7:9000/observatory/Dossen202110GainReport1634900446501.png]";
//
//        String[] split = str.split(",");
//
//        String url = split[4];
//        String[] split1 = url.split("]");
//        System.err.println(split1[0]);
//
//        System.err.println(new Random().nextInt(50));
//
//        System.err.println(UUID.randomUUID());
        Date currentInteger = new Date();

        Date nLastDay = DateTimeUtils.getNLastDay(currentInteger);
        String current = DateTimeUtils.getInteger(currentInteger);
        String last30 = DateTimeUtils.getInteger(nLastDay);
        System.err.println(current);
        System.err.println(last30);

    }

}
