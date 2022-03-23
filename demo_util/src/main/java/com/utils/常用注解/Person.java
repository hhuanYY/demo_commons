package com.utils.常用注解;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: yuanyinhuan
 * @date: 2022/1/18 15:53
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    private String name;
    private Integer age;
}
