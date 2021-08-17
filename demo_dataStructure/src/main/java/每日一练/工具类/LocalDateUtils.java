package 每日一练.工具类;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @projectName: dataStructure
 * @className: LocalDateUtils
 * @author: yuanyinhuan
 * @description:
 * @date: 2021/7/20 9:42
 */
public class LocalDateUtils {
    public static void main(String[] args) {
        // 1、获取当前日期（2021-07-20） --  LocalDate -- 只对年月日做处理
        LocalDate today = LocalDate.now();
        System.err.println(today);

        // 2、返回哪一年
        int dayOfYear = today.getDayOfYear();
        System.err.println(dayOfYear);

        int value = today.getDayOfWeek().getValue();
        System.err.println(value);

        int dayOfMonth = today.getDayOfMonth();
        System.err.println(dayOfMonth);

        // 获取本月第一天
        LocalDate with = today.with(TemporalAdjusters.firstDayOfMonth());
        System.err.println(with);

        // 获取本月最后一天
        LocalDate with1 = today.with(TemporalAdjusters.lastDayOfMonth());
        System.err.println(with1);



//        // LocalDate ->字符串 格式化
//        DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyyMM");
//        String format = today.format(yyyyMM);
//        System.err.println(format);
//
//        // 字符串 ->LocalDate
//        String str = "2021-07-18";
//        LocalDate parse = LocalDate.parse(str);
//        System.err.println(parse);



    }
}
