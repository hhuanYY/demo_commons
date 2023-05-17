package com.utils.Bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/8
 */
@Component
@Slf4j
public abstract class DemoService<T,R> {
    public abstract R methodDemo(String str);
}
