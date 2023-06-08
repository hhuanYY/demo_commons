package com.utils.api.controller.redisson.listener;

import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/6/8
 */
@Component
public class RedissonListener implements ApplicationRunner {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("开始监听...");

        /*指定监听某个库*/
        int database = 6;
        RTopic topic = redissonClient.getTopic("__keyevent@" + database + "__:expired", new StringCodec());
        // 处理过期 Key 的逻辑 channel:指示database(__keyevent@6__:expired)  message:代表那个Key(aKBWKIel)
        topic.addListener(String.class, (channel, message) -> {
            System.out.println("收取到过期的事件:" + channel + "; Thread: " + Thread.currentThread().toString());
            System.out.println("过期的key="+message);

        });
    }

}
