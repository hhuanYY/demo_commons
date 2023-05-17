package com.utils.Bean.impl;

import com.utils.Bean.DemoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/8
 */
@Service("select_bean")
public class SelectDemoServiceImpl extends DemoService<String,String> {
    @Override
    public String methodDemo(String s) {
        return null;
    }
}
