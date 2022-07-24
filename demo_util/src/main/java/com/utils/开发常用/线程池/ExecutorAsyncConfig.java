package com.utils.开发常用.线程池;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ProjectName：demo_commons
 * @ClassDesc： 自定义线程池
 * @Author：yyhuan
 * @CreateTime：2022/6/17
 */
@Configuration
@EnableAsync
public class ExecutorAsyncConfig {
    @Value("${async.executor.thread.core_pool_size}")
    private int CORE_POOL_SIZE;

    @Value("${async.executor.thread.max_pool_size}")
    private int MAX_POOL_SIZE;

    @Value("${async.executor.thread.queue_capacity}")
    private int QUEUE_CAPACITY;

    @Value("${async.executor.thread.keep_alive_seconds}")
    private int KEEP_ALIVE_SECONDS;

    @Value("${async.executor.thread.name_prefix}")
    private String THREAD_NAME_PREFIX;

    @Bean(name = "dossen_async")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();

        //线程池维护的核心线程数
        poolTaskExecutor.setCorePoolSize( CORE_POOL_SIZE );
        //线程池维护的最大线程数
        poolTaskExecutor.setMaxPoolSize( MAX_POOL_SIZE );
        //线程池使用的阻塞队队列长度
        poolTaskExecutor.setQueueCapacity( QUEUE_CAPACITY );
        //线程池维护线程锁允许的空闲时间
        poolTaskExecutor.setKeepAliveSeconds( KEEP_ALIVE_SECONDS );
        //自定义线程自定义名称
        poolTaskExecutor.setThreadNamePrefix( THREAD_NAME_PREFIX );

        poolTaskExecutor.setRejectedExecutionHandler( new ThreadPoolExecutor.CallerRunsPolicy() );
        poolTaskExecutor.setWaitForTasksToCompleteOnShutdown( true );
        poolTaskExecutor.setAwaitTerminationMillis( 20 );
        poolTaskExecutor.initialize();

        return poolTaskExecutor;
    }

}
