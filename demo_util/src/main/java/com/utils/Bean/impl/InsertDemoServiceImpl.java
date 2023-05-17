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
@Service("insert_bean")
public class InsertDemoServiceImpl extends DemoService<String,String> {
    @Override
    public String methodDemo(String s) {
        return null;
    }
}
