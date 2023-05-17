package com.utils.多线程;

/**
 * @ClassName ThreadDemo
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/3/19 14:26
 * @Version 1.0
 */
public class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
