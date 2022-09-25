package com.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName LocalDateDemo
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/16 23:09
 * @Version 1.0
 */
public final class LocalDateDemo {
    /**
     * date转LocalDate
     * @param date
     * @return
     */
    public static LocalDate date2LocalDate(Date date) {
        if(null == date) {
            return null;
        }6
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Date localDate2Date(LocalDate localDate) {
        if(null == localDate) {
            return null;
        }
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String formatDate(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}

class MainTest{
    public static void main(String[] args) {

        System.out.println(15666%10000);

        System.out.println(155/10);

        LocalDate parse = LocalDate.parse("2022*02*01", DateTimeFormatter.ofPattern("yyyy*MM*dd"));
        System.out.println(parse);

        String yyyyMMdd = DateTimeFormatter.ofPattern("yyyyMMdd").format(parse);
        String yyyyMMdd1 = parse.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        System.out.println(yyyyMMdd);

        LocalDate localDate = LocalDateDemo.date2LocalDate(new Date());
        System.out.println(localDate);

    }
}


class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
        }

        int reverserNum = 0;
        while (x > reverserNum) {
            reverserNum = reverserNum * 10 + x % 10;
            x /= 10;
        }
        return x == reverserNum || x == reverserNum / 10;
    }
}

