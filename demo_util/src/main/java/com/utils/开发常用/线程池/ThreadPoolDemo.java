package com.utils.开发常用.线程池;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;

/**
 * @ProjectName：demo_commons
 * @ClassDesc：
 * @Author：yyhuan
 * @CreateTime：2022/6/8
 */
public class ThreadPoolDemo {
//    private static final ExecutorService threadPool = Executors.newFixedThreadPool( 5 );

    @Resource
    private ThreadPoolTaskExecutor taskExecutor;

    public static void main(String[] args) {
//
//
//        System.out.println("1000000");
//        for (int i = 0 ; i <= 1; i++) {
//            threadPool.execute( new MyRunnable() );
//        }
//        threadPool.shutdown();
//
//        System.out.println("1000000");


//        ExecutorService service = Executors.newCachedThreadPool();
//        for (int i = 0 ; i < 10 ; i++) {
//            int finalI = i;
//            service.submit( () -> {
//                System.out.println( "i : " + finalI + "|线程名称：" + Thread.currentThread().getName() );
//            } );
//        }

//        retry:
//        for (int i = 0 ; i < 5 ; i++) {
//            for (int j = 0 ; j < 3 ; j++) {
//                break retry;
//            }
//        }

//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync( ()->{
//            return "123";
//        });


//        try {
//
//
//            String s = completableFuture.get();
//            completableFuture.join();
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//
//        AtomicInteger atomicInteger = new AtomicInteger();
//        atomicInteger.get();



    }
}
