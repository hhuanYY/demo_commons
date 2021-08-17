package other.LinkedListTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LinkedListTest {
    public static void main(String[] args) {
//        System.err.println(getLastMonth());
//        Integer oneYearAgoMonth = getOneYearAgoMonth(getLastMonth());
//        System.err.println(oneYearAgoMonth);
        String yearDate = getYearDate(2);
        System.err.println(yearDate);
    }

    public static Integer getOneYearAgoMonth(int month) {
        int yearNum = month / 100;
        int monthNum = month % 100;
        if (monthNum>=12){
            return (yearNum)*100+1;
        }
        return (yearNum-1)*100+monthNum+1;
    }


    public static Integer getLastMonth() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date); // 设置为当前时间
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1); // 设置为上一个月
        date = calendar.getTime();
        String accDate = format.format(date);
        return Integer.valueOf(accDate);
    }

    public static String getYearDate(int year){
        Calendar curr = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)-year);
        return sdf.format( curr.getTime() );
    }

}
