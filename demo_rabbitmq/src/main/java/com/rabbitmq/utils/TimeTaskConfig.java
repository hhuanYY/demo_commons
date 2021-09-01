package com.rabbitmq.utils;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author: yuanyinhuan
 * @date: 2021/9/1 14:46
 */

@EnableScheduling
@Component
public class TimeTaskConfig {

    @PostConstruct // 项目启动时自动调用一次
    @Scheduled(cron = "0 15 15 1 * ?") // 每个月1号
    public static void timeTaskTest() {
        System.out.println("每个月1号15点10分执行" +"-------"+ new Date());
    }

}
