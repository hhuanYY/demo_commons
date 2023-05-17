package com.utils.api.controller;

import com.utils.ThreadPoolTaskConfig;
import com.utils.api.FieldDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/13 19:11
 * @Version 1.0
 */
@Controller
public class TestController {

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Object> getTest() {

        FieldDemo fieldDemo = new FieldDemo();
        fieldDemo.setUSER_NAME("yyh");
        fieldDemo.setPASSWORD("123");
        fieldDemo.setCreateTIME(new Date());
        System.out.println(Thread.currentThread());
        return new HttpEntity<>(Thread.currentThread().getName());
    }

    @Autowired
    private ThreadPoolTaskConfig threadPool;

    @RequestMapping(value = "/api/thread/get", method = RequestMethod.GET)
    @ResponseBody
    public String testThread(HttpServletRequest request) {
        ThreadPoolTaskExecutor executor = threadPool.getThreadPoolTaskExecutor();
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executor.execute(()->{
                System.out.println(finalI + ":" + Thread.currentThread().getName());
            });
        }

        return "当前在线人数：" + request.getSession().getServletContext().getAttribute("count");
    }


}
