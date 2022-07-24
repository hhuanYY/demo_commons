package com.utils.开发常用.定时任务;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @ProjectName：demo_commons
 * @ClassDesc：
 * @Author：yyhuan
 * @CreateTime：2022/4/2
 */
@Service
public class DemoServiceImpl {

    @Async
    public void demo() throws InterruptedException {
        System.err.println( Thread.currentThread().getName() + ": 异步线程结束执行...1" );
        System.err.println( Thread.currentThread().getName() + ": 异步线程结束执行...2" );
        System.err.println( Thread.currentThread().getName() + ": 异步线程结束执行...3" );
        Thread.sleep( 5000 );
        System.err.println( Thread.currentThread().getName() + ": 执行完毕..." );
        System.err.println( "-------------------------------" );
    }


    @Async("dossen_async")
    public void asyncT(){
        for (int i = 0 ; i < 100 ; i++) {
            try {
                Thread.sleep( 2000 );
                System.out.println( Thread.currentThread().getName() + "执行完毕..." + i );
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


}
