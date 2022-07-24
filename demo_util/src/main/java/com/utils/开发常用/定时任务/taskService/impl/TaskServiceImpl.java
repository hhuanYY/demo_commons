package com.utils.开发常用.定时任务.taskService.impl;

import com.utils.开发常用.定时任务.taskService.TaskService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

/**
 * @ProjectName：demo_commons
 * @ClassDesc：
 * @Author：yyhuan
 * @CreateTime：2022/6/8
 */
@EnableAsync
@Service
public class TaskServiceImpl implements TaskService {

    @Async("dossen_async")
    @Override
    public void test01() throws InterruptedException {
        for (int i = 0 ; i < 3 ; i++) {
            System.err.println( "test01: "+Thread.currentThread().getName() + ": 异步线程结束执行..." );
            Thread.sleep( 3000 );
        }

    }

    @Async("dossen_async")
    @Override
    public void test02() throws InterruptedException {
        for (int i = 0 ; i < 3 ; i++) {
            System.err.println( "test02: "+Thread.currentThread().getName() + ": 异步线程结束执行..." );
            Thread.sleep( 2000 );
        }
    }

    @Async("dossen_async")
    @Override
    public void test03() throws InterruptedException {
        for (int i = 0 ; i < 3 ; i++) {
            System.err.println( "test03: "+Thread.currentThread().getName() + ": 异步线程结束执行..." );
            Thread.sleep( 1000 );
        }
    }
}
