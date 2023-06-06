package com.utils.api.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/26
 */
@Async
@Component
public class CustomizeListener implements ApplicationListener<CustomizeEvent> {

    @Override
    public void onApplicationEvent(CustomizeEvent customizeEvent) {
        System.out.println("STR_事件监听器(异步):开始执行");
        System.out.println("STR_事件监听器获取到请求入参:" + customizeEvent.getStr());

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("STR_事件监听器(异步):执行结束");
    }
}
