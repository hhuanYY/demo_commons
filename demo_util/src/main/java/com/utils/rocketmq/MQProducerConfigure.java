package com.utils.rocketmq;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yuanyinhuan
 * @date: 2021/10/9 14:08
 */
@Data
@ToString
@Configuration
@ConfigurationProperties(prefix = "dossen.rocketmq.producer")
public class MQProducerConfigure {

    private String groupName;

    private String namesrvAddr;

    //消息最大值
    private Integer maxMessageSize;

    //消息发送超时时间
    private Integer sendMsgTimeOut;

    //失败重试次数
    private Integer retryTimesWhenSendFailed;



}
