package com.utils;

import org.springframework.boot.CommandLineRunner;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/18
 */
//@Component
public class ScheduleDemo implements CommandLineRunner {

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

    @Override
    public void run(String... args) throws Exception {
        executorService.scheduleAtFixedRate(()->{
            // 在此处编写需要延时执行的任务逻辑
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "--------" + i);
            }
        },5,10,TimeUnit.SECONDS);
    }
}
