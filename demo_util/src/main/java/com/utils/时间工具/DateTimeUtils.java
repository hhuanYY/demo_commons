package com.utils.时间工具;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author: yuanyinhuan
 * @date: 2021/8/19 11:31
 */
public class DateTimeUtils {


    /**
     * 获取昨天
     * @param time
     * @return
     */
    public static Date getLastDay(Date time){
        if (time==null){
            time = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(time);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static Date getStringToDate(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(str);
    }


    /**
     * 获取上月上一天
     * @return 获取上月上一天
     */
    public static Date getLastMonthLastDayCurrent(Date time){
        if (time==null){
            time = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(time);
        calendar.add(Calendar.MONTH, -1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static Date getServerDate() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(now);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * Date转字符串
     * @param time
     * @return
     */
    public static String getStringFormatDate(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format( time );
    }

    public static String getInteger(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format( time );
    }

    /**
     * 获取n周之前的时间
     * @param time
     * @return
     */
    public static Date getNLastWeek(Date time){
        if (time==null){
            time = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(time);
        calendar.add(Calendar.DAY_OF_WEEK, -1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }


    public static Date getNLastDay(Date time){
        if (time==null){
            time = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(time);
        calendar.add(Calendar.DATE,-30);
        return calendar.getTime();
    }


    /**
     * 获取指定月份的18个月前的 月份
     * @param month
     * @return
     */
    public static Integer getNLastMonth(Integer month) {
        String monthStr = String.valueOf(month);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        String string = "";
        try {
            Date dataMonth = simpleDateFormat.parse(monthStr);
            Calendar instance = Calendar.getInstance();
            instance.clear();
            instance.setTime(dataMonth);
            instance.add(Calendar.MONTH, -17);
            string = getString(instance.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Integer.valueOf(string);
    }


    public static String getString(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format( time );
    }


    /**
     * 获取到传入日期所在星期的周一 ( "2021-08-29" --> "2021-08-23"周一 )
     * @param data
     * @return
     * @throws ParseException
     */
    public static Date getThisWeekMonday2(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(data);

        Calendar cld = Calendar.getInstance(Locale.CHINA);
        cld.setTime(parse);
        cld.setFirstDayOfWeek(Calendar.MONDAY);//以周一为首日
        cld.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//周一

        return cld.getTime();
    }

}
