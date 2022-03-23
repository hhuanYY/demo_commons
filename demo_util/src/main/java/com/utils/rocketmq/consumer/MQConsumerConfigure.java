package com.utils.rocketmq.consumer;

import lombok.Data;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yuanyinhuan
 * @date: 2022/3/23 10:06
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "dossen.rocketmq.consumer")
public class MQConsumerConfigure {
    private String groupName;
    private String namesrvAddr;
    private String topics;
    private Integer consumeThreadMin;
    private Integer consumeThreadMax;
    private Integer consumeMessageBatchMaxSize;

    @Autowired
    private MQConsumerMsgListenerProcessor consumerMsgListenerProcessor;

    @Bean
    @ConditionalOnProperty(prefix = "dossen.rocketmq.consumer", value = "isOnOff", havingValue = "on")
    public DefaultMQPushConsumer defaultConsume() {
        System.err.println("正在创建消费者");
        DefaultMQPushConsumer defaultMQPushConsumer = new DefaultMQPushConsumer();
        defaultMQPushConsumer.setConsumerGroup(groupName);
        defaultMQPushConsumer.setNamesrvAddr(namesrvAddr);
        defaultMQPushConsumer.setConsumeThreadMin(consumeThreadMin);
        defaultMQPushConsumer.setConsumeThreadMax(consumeThreadMax);
        defaultMQPushConsumer.setConsumeMessageBatchMaxSize(consumeMessageBatchMaxSize);
        //设置监听
        defaultMQPushConsumer.registerMessageListener(consumerMsgListenerProcessor);
        defaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

        // 获取额外的消息属性,来过滤消


        /**
         * 同一个消费者组可以通过设置消费模式,来控制消费者的模式为集群/广播 (默认是集群模式)
         * 不同的消费者组就是广播模式
         */
        //设置消费模型,集群还是广播,默认是集群: CLUSTERING(负载均衡模式)    BROADCASTING(广播模式)
        defaultMQPushConsumer.setMessageModel(MessageModel.CLUSTERING);


        try {
            String[] topicAndTag = topics.split(":");
            defaultMQPushConsumer.subscribe(topicAndTag[0],topicAndTag[1]);

            defaultMQPushConsumer.subscribe(topicAndTag[0], MessageSelector.bySql("age>16"));

            defaultMQPushConsumer.start();
            System.err.println("消息者创建成功: topic={" + topicAndTag[0] + "}, tag={" + topicAndTag[1] + "}");

        } catch (Exception e) {
            System.out.println("消费者创建失败: "+e.getMessage());
        }

        return defaultMQPushConsumer;
    }

}

