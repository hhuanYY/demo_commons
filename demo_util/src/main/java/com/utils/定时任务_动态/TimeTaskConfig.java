package com.utils.定时任务_动态;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

/**
 * @author: yuanyinhuan
 * @date: 2021/9/1 14:46
 */

//@EnableScheduling // 启动类里面使用@EnableScheduling 注解开启功能，开启自动扫描；
//@Configuration
//class TimeTaskConfigAuto implements SchedulingConfigurer {
//
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.addTriggerTask(
//                ()-> System.err.println("动态执行定时任务: "+ System.currentTimeMillis()),
//                triggerContext -> {
//                    String cron = "0/3 * * * * ?";
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
//                });
//    }
//}
