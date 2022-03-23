package com.utils.rocketmq.producer;

import lombok.Data;
import lombok.ToString;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
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

    @Bean
    @ConditionalOnProperty(prefix = "dossen.rocketmq.producer", value = "isOnOff", havingValue = "on")
    public DefaultMQProducer defaultMQProducer() throws MQClientException {
        System.err.println("正在创建MQ生产者");
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer(groupName);
        defaultMQProducer.setNamesrvAddr(namesrvAddr);
        defaultMQProducer.setVipChannelEnabled(false);
        defaultMQProducer.setMaxMessageSize(maxMessageSize);
        defaultMQProducer.setSendMsgTimeout(sendMsgTimeOut);
        defaultMQProducer.setRetryTimesWhenSendAsyncFailed(retryTimesWhenSendFailed);
        defaultMQProducer.start();
        System.err.println("MQ生产者创建成功");
        System.err.println(namesrvAddr);
        System.err.println(groupName);
        return defaultMQProducer;
    }

}
