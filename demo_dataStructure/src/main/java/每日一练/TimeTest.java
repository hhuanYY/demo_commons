package 每日一练;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @projectName: dataStructure
 * @className: TimeTest
 * @author: yuanyinhuan
 * @description:
 * @date: 2021/7/5 9:17
 */
public class TimeTest {
    public static void main(String[] args) throws ParseException {
        Integer yearDateAndMonth = getYearDateAndMonth(1);
        System.err.println(yearDateAndMonth);
    }

    public static Integer getYearDateAndMonth(int year){
        Calendar curr = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)-year);
        return Integer.valueOf(sdf.format( curr.getTime() ));
    }

}

