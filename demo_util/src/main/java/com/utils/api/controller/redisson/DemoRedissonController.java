package com.utils.api.controller.redisson;

import cn.hutool.core.lang.id.NanoId;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/6/8
 */
@Controller
public class DemoRedissonController {

    @Autowired
    private RedissonClient redissonClient;

    public static final String KEY = "REDISSON:TEST:";

    @RequestMapping(value = "redissonTest", method = RequestMethod.GET)
    @ResponseBody
    public String redissonTest() {
        redissonClient.<String>getBucket(KEY + NanoId.randomNanoId(8)).set(NanoId.randomNanoId(), 20, TimeUnit.SECONDS);
        return "success";
    }

}
