package com.utils.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName DemoBeanConfig
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/7 17:24
 * @Version 1.0
 */
@ComponentScan("com.utils")
public class DemoBeanConfig {

    @Bean
    public BeanDemo getBeanDemo(){
        return new BeanDemo();
    }
}

