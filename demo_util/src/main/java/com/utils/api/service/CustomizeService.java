package com.utils.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/26
 */
@Service
@Slf4j
public class CustomizeService {

    @Autowired
    private ApplicationContext applicationContext;

//    public String customized(Integer id){
//        CustomizeEvent event = new CustomizeEvent(this);
//        applicationContext.publishEvent(event);
//        System.out.println("事件发布成功");
//        return "";
//    }


    @Async
    public String asyncDemo01() {
        try {
            System.out.println("asyncDemo01_开始执行:" + Thread.currentThread().getName());
            int i = 1/0;

        } catch (Exception e){
            e.printStackTrace();
//            log.error("异常了",e);
//            throw new RuntimeException("异常....",e);
        }

        return "asyncDemo01_业务执行完毕";
    }

//    @Async
    public void asyncDemo02() {
        try {
//            int i = 1/0;
            System.out.println("asyncDemo02_开始执行:"+Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("asyncDemo02_执行完毕:" + Thread.currentThread().getName());
        } catch (Exception e) {
            log.error("is a error",e);
        }
    }

}
