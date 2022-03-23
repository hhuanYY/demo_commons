package com.utils.时间工具;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author: yuanyinhuan
 * @date: 2021/8/19 11:32
 */
public class MainDemo {
    public static void main(String[] args) throws ParseException {

        String monthEnd = DateTimeUtils.isMonthEnd();
        System.err.println(monthEnd);

        String weekEnd = DateTimeUtils.isWeekEnd();
        System.err.println(weekEnd);

        List<String> betweenTwoTime = DateTimeUtils.getBetweenTwoTime("202101", "202202");

        String integer = DateTimeUtils.getInteger(DateTimeUtils.getSpecifyStartTime(-1));
        System.err.println(integer);


//        Date lastMonthLastDayCurrent = DateTimeUtils.getLastMonthLastDayCurrent(new Date());
//        String stringFormatDate = DateTimeUtils.getStringFormatDate(lastMonthLastDayCurrent);
//        System.err.println(stringFormatDate);
//
//        Date nLastWeek = DateTimeUtils.getNLastWeek(new Date());
//        String string = DateTimeUtils.getString(nLastWeek);
//        System.err.println(":----"+ string);
//
//        Date thisWeekMonday2 = DateTimeUtils.getThisWeekMonday2("2021-08-29");
//        String string1 = DateTimeUtils.getString(thisWeekMonday2);
//        System.err.println(string1);

//        Integer nLastMonth = DateTimeUtils.getNLastMonth(202108);
//        System.err.println(nLastMonth);
//

//        String stringFormatDate = DateTimeUtils.getInteger(DateTimeUtils.getLastDay(new Date()));
//        System.err.println(stringFormatDate);


//        String str = "2021-11-05";
//        Date stringToDate = DateTimeUtils.getStringToDate(str);
//
//        Date lastDay = DateTimeUtils.getLastDay(stringToDate);
//
//        String integer = DateTimeUtils.getInteger(lastDay);
//
//        System.err.println(integer);

//        String lastMonthOneDay = DateTimeUtils.getLastMonthOneDay();
//        System.err.println(lastMonthOneDay);

    }
}
