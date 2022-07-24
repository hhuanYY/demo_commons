package com.utils.开发常用.线程池;

import java.util.concurrent.*;

/**
 * @ProjectName：demo_commons
 * @ClassDesc：基于Executors的静态工厂方法创建线程池
 * @Author：yyhuan
 * @CreateTime：2022/6/17
 */
public class ExecutorConfig {

    /**定长线程池,采用LinkedBlockingQueue队列--基于链表的阻塞队列*/
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor( nThreads,nThreads,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>() );
    }

    /**可缓存线程池,使用SynchronousQueue同步队列*/
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor( 0,Integer.MAX_VALUE,60L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>() );
    }

    /**定长线程池,使用DelayedWorkQueue延迟队列*/
    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }
}
