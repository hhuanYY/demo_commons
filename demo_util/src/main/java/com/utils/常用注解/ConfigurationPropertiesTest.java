package com.utils.常用注解;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yuanyinhuan
 * @date: 2022/1/18 15:19
 */
public class ConfigurationPropertiesTest {

    @Autowired
    private Person person;

    public static void main(String[] args) {
    }

}
