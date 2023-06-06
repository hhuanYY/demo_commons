package com.utils;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Objects;

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
    public void demo11() throws IllegalAccessException, NoSuchMethodException {
        UserDemo user = new UserDemo();
        user.setUsername("A20230523");
        user.setAddress("Address");
        user.setAge(1);

        Class<? extends UserDemo> userClass = user.getClass();

        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object originalValue = field.get(user);

            if (Objects.nonNull(originalValue)) {
                if (originalValue instanceof String) {
                    field.set(user,((String) originalValue).replaceAll("A","#"));
                } else if (originalValue instanceof Integer) {
                    field.set(user,1000);
                }
            }
        }

        System.out.println(user);


        UserDemo userDemo = new UserDemo();











    }

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
