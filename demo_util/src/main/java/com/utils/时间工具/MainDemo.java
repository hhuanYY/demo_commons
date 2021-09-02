package com.utils.时间工具;

import java.text.ParseException;
import java.util.Date;

/**
 * @author: yuanyinhuan
 * @date: 2021/8/19 11:32
 */
public class MainDemo {
    public static void main(String[] args) throws ParseException {
//        Date lastMonthLastDayCurrent = DateTimeUtils.getLastMonthLastDayCurrent(new Date());
//        String stringFormatDate = DateTimeUtils.getStringFormatDate(lastMonthLastDayCurrent);
//        System.err.println(stringFormatDate);
//
        Date nLastWeek = DateTimeUtils.getNLastWeek(new Date());
        String string = DateTimeUtils.getString(nLastWeek);
        System.err.println(":----"+ string);

        Date thisWeekMonday2 = DateTimeUtils.getThisWeekMonday2("2021-08-29");
        String string1 = DateTimeUtils.getString(thisWeekMonday2);
        System.err.println(string1);

    }
}
