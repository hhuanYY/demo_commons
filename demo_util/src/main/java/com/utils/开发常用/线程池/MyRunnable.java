package com.utils.开发常用.线程池;

/**
 * @ProjectName：demo_commons
 * @ClassDesc：
 * @Author：yyhuan
 * @CreateTime：2022/6/8
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println( Thread.currentThread().getName() + ": ");
        try {
            Thread.sleep( 1000 );
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
