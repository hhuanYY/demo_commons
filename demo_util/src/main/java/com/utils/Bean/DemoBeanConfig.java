package com.utils.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DemoBeanConfig
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/7 17:24
 * @Version 1.0
 */
@Configuration
public class DemoBeanConfig {

    @Bean("demoBean")
    public static String getDemoBean() {
        return "demoBean test";
    }

}
