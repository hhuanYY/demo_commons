package com.utils;

import com.utils.时间工具.DateTimeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

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

//        Logger logger = LogManager.getLogger(Str.class);
////        logger.info("INFO级别日志{}" + DateTimeUtils.getStringFormatDate(new Date()));
////        logger.debug("DEBUG级别日志{}" + DateTimeUtils.getStringFormatDate(new Date()));
////        logger.error("ERROR级别日志{}" + DateTimeUtils.getStringFormatDate(new Date()));
////        logger.trace("TRACE级别日志{}" + DateTimeUtils.getStringFormatDate(new Date()));
////        logger.warn("WARN级别日志{}" + DateTimeUtils.getStringFormatDate(new Date()));


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
