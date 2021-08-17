package 每日一练.工具类;

import java.time.LocalDateTime;

/**
 * @projectName: dataStructure
 * @className: LocalDateTimeUtils
 * @author: yuanyinhuan
 * @description:
 * @date: 2021/7/20 10:18
 */
public class LocalDateTimeUtils {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.err.println(now);



        int second = now.getSecond();
        System.err.println(second);

    }
}
