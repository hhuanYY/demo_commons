package com.utils.测试;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/12
 */
@SpringBootTest
public class DateUtilsDemo {

    @Test
    public void getLastWeekDate() {

        LocalDateTime lastMont = LocalDateTime.now().minusMonths(1);
        System.out.println(Date.from(lastMont.atZone(ZoneId.systemDefault()).toInstant()));


        LocalDateTime lastWeekDay = LocalDateTime.now().minusDays(7);
        LocalDateTime monday = lastWeekDay.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDateTime with = lastWeekDay.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        System.out.println(monday);
        System.out.println(with);


        LocalDateTime months = LocalDateTime.now().minusMonths(1);
        System.out.println(months.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(months.with(TemporalAdjusters.lastDayOfMonth()));


    }

}
