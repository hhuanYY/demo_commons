package com.utils.api;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author: yuanyinhuan
 * @date: 2022/3/1 19:57
 */
@Service
public class TestServiceImpl implements TestService{

    @Async
    @Override
    public void test() {
        System.err.println("异步调用执行: " + Thread.currentThread().getName());
    }
}
