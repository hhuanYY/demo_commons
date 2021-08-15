package com.rabbitmq.发布订阅模式;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.utils.ConnRabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class PubsubConsumer02 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel connRabbitMQ = ConnRabbitMQUtils.getConnRabbitMQ();
        // 1.创建交换机
        connRabbitMQ.exchangeDeclare("lombok", "fanout");
        // 2.创建队列 (系统自定义队列: 随机命名 非持久 独占 自动删除)
        String queueName = connRabbitMQ.queueDeclare().getQueue();
        // 3.队列绑定交换机 (交换机与队列绑定)
        /** 绑定队列与交换机
         * 参数1：队列名
         * 参数2：交换机名
         * 参数3：路由键(生产者设置)
         */
        connRabbitMQ.queueBind(queueName,"lombok","");

        DeliverCallback deliverCallback = (s, delivery) -> {
            byte[] body = delivery.getBody();
            String msg = new String(body);
            System.err.println("收到消息:" + msg);
        };

        CancelCallback cancelCallback = s -> {

        };

        connRabbitMQ.basicConsume(queueName, true, deliverCallback, cancelCallback);

    }
}
