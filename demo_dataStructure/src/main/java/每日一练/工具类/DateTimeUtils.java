package 每日一练.工具类;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @projectName: dataStructure 
 * @className: DateTimeUtils
 * @author: yuanyinhuan
 * @description:   
 * @date: 2021/7/5 9:16
 */
public class DateTimeUtils {

    public static long getTomorrowZeroTime() {
        Calendar cal = Calendar.getInstance();
        //控制日期,明天
        cal.add(Calendar.DATE, 1);
        //控制时
        cal.set(Calendar.HOUR_OF_DAY, 0);
        // 控制分
        cal.set(Calendar.MINUTE, 0);
        // 控制秒
        cal.set(Calendar.SECOND, 0);
        // 当天12点的时间
        Date time = cal.getTime();
        return time.getTime();
    }

    /**
     * 获取服务器日期
     */
    public static Date getServerTime() {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        return calendar.getTime();
    }


    public String getLastMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        String accDate = format.format(date);
        return accDate;
    }

}
