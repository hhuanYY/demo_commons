package 时间工具;

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
     * Date转字符串
     * @param time
     * @return
     */
    public static String getStringFormatDate(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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

    public static String getString(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
