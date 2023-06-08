package com.utils.api.controller.redisson.util;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/6/8
 */
@Configuration
public class RedissonConfig {

    @Value("${redisson.database}")
    private Integer database;
    @Value("${redisson.hostAndPort}")
    private String hostAndPort;
    @Value("${redisson.password}")
    private String password;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        /*Redisson默认是以二进制格式存储,*/
        config.setCodec(JsonJacksonCodec.INSTANCE);
        config.useSingleServer()
                .setAddress(hostAndPort)
                .setDatabase(database)
                .setPassword(password)
                .setConnectionPoolSize(500)
                .setIdleConnectionTimeout(10000)
                .setTimeout(3000)
                .setConnectTimeout(30000)
                .setRetryAttempts(3)
                .setRetryInterval(1000)
                .setDnsMonitoringInterval(-1)
                .setPingConnectionInterval(10000);
        return Redisson.create(config);
    }
}
