package com.utils.日常api.时间工具;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /**
     * 获取当月最后一天
     * @return
     */
    public static String isMonthEnd() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return format.format(ca.getTime());
    }

    /**
     * 获取本周周日
     * @return
     */
    public static String isWeekEnd(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_WEEK, ca.getActualMaximum(Calendar.DAY_OF_WEEK));
        ca.add(Calendar.DATE,+1);
        return format.format(ca.getTime());
    }


    /**
     * 获取上月一号的数据
     * @return
     */
    public static String getLastMonthOneDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return sdf.format(cal.getTime());
    }


    /**
     * 获取服务器时间
     * @return
     */
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
     * 获取指定天数的日期 例如:interval参数是-1, 则获取的是昨天的日期
     * @param interval
     * @return
     */
    public static Date getSpecifyStartTime(Integer interval) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.add(Calendar.DATE, interval);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
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


    /**
     * 获取两个日期(yyyyMM)中间的月份日期集合,包含开始日期月份和结束日期月份
     */
    public static List<String> getMonthListBetween(String startDate, String endDate){
        List<String> months=new ArrayList<>();
        Calendar startTime=Calendar.getInstance();
        Calendar endTime=Calendar.getInstance();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        try {
            //将开始日期设置给calendar
            startTime.setTime(simpleDateFormat.parse(startDate));
            System.out.println("开始日期="+simpleDateFormat.format(startTime.getTime()));

            //月份减1,包含开始日期月份
            startTime.add(Calendar.MONTH,-1);

            //将结束日期设置给calendar
            endTime.setTime(simpleDateFormat.parse(endDate));

            System.out.println("结束日期="+simpleDateFormat.format(endTime.getTime()));
            while (startTime.before(endTime)){
                startTime.add(Calendar.MONTH,1);
                months.add(simpleDateFormat.format(startTime.getTime()));
            }
            System.out.println("months="+months);
        }catch (Exception e){
            e.printStackTrace();
        }
        return months;
    }


    /**
     * 获取两个日期之间相隔的月份列表
     * @param startTime
     * @param endTime
     * @return
     */
    public static List<String> getBetweenTwoTime(String startTime,String endTime) {
        List<String> list = new ArrayList<>();
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
            start.setTime(simpleDateFormat.parse(startTime));
            start.add(Calendar.MONTH,-1);
            System.err.println("开始时间:"+start.getTime());

            end.setTime(simpleDateFormat.parse(endTime));
            System.err.println("结束时间:"+end.getTime());

            while (start.before(end)) {
                start.add(Calendar.MONTH, +1);
                Date time = start.getTime();
                list.add(simpleDateFormat.format(start.getTime()));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return list;
    }


    /**
     * 获取今天的开始时间
     * @return 时间
     */
    public static Date getStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取今天指定几点时间
     * @param hour 小时
     * @param minute 分钟
     * @return 时间
     */
    public static Date getHourTime(Integer hour,Integer minute) {
        Calendar todayHour = Calendar.getInstance();
        todayHour.set(Calendar.HOUR_OF_DAY, hour);
        todayHour.set(Calendar.MINUTE, minute);
        todayHour.set(Calendar.SECOND, 0);
        todayHour.set(Calendar.MILLISECOND, 0);
        return todayHour.getTime();
    }


    public static String test() {
        Calendar instance = Calendar.getInstance();
        instance.set( Calendar.DAY_OF_MONTH,1 );
        instance.set( Calendar.HOUR_OF_DAY,0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return DateTimeUtils.getStringFormatDate( instance.getTime() );
    }



}
