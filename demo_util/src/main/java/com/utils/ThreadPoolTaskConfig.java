package com.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @ClassName ThreadPoolTaskConfig
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/4/9 16:38
 * @Version 1.0
 */
@Configuration
public class ThreadPoolTaskConfig {
    @Bean
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        //设置核心线程数
        threadPoolTaskExecutor.setCorePoolSize(12);
        //设置最大线程数
        threadPoolTaskExecutor.setMaxPoolSize(100);
        //除核心线程外的线程存活时间
        threadPoolTaskExecutor.setKeepAliveSeconds(3);
        //如果传入值大于0，底层队列使用的是LinkedBlockingQueue,否则默认使用SynchronousQueue
        threadPoolTaskExecutor.setQueueCapacity(Integer.MAX_VALUE);
        //线程名称前缀
        threadPoolTaskExecutor.setThreadNamePrefix("thread-execute");
        //设置拒绝策略
        threadPoolTaskExecutor.setRejectedExecutionHandler((r, executor) -> {
            try {
                System.out.println("重回队列");
                executor.getQueue().put(r);
            } catch (Exception e) {

            }
        });
        return threadPoolTaskExecutor;
    }
}
