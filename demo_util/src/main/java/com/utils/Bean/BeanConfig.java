package com.utils.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @ClassName BeanConfig
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/13 19:04
 * @Version 1.0
 */
public class BeanConfig {
    @Autowired
    private ApplicationContext ctx;

    public <T> T getBeanByClass(Class<T> t) {
        return ctx.getBean(t);
    }
}
