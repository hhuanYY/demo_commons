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

//    @PostConstruct // 项目启动时自动调用一次
    @Scheduled(cron = "30-45 32 * 1 * ?")
    public static void timeTaskTest() {
        System.out.println("每个月1号的每分钟执行一次" +"-------"+ new Date());
    }

}
