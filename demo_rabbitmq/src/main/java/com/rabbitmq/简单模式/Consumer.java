package com.rabbitmq.简单模式;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.utils.ConnRabbitMQUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者
 */
@Slf4j
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = ConnRabbitMQUtils.getConnRabbitMQ();

        // 定义队列(生产者、消费者都需要定义队列,防止消费者先启动后,队列不存在)
        /** 1.定义队列：如果队列不存在则新建、否则新建
         * 参数1：队列名
         * 参数2：是否是一个持久队列 (true:服务器重启不会消失；false:服务器重启会消失)
         * 参数3：是否是一个独占队列 (true:只能当前客户端使用；false:公共队列)
         * 参数4：是否自动删除 (true:没有消费者消费时自动删除)
         * 参数5：其他可配置参数
         */
        channel.queueDeclare("welcome", false, false, false, null);

        // 处理消息的回调对象
        DeliverCallback deliverCallback = (s, delivery) -> {
            // 取出消息(消费者发送的是字节数组)
            byte[] body = delivery.getBody();
            String str = new String(body);
            System.err.println("收到消息：" + str);
        };

        // 取消接收消息的回调对象
        CancelCallback cancelCallback = s -> {

        };

        /** 2.接收消息
         * 参数1：队列名（从指定队列中消费消息）
         * 参数2：是否自动确认（true:自动确认后,无论消息是否消费完，都会不停地轮询分发消息并直接删除队列中的该消息）
         *                   false:手动确认,消息未消费完时，队列不会删除掉该消息，只有消费者回传了成功处理的响应后才会删除队列中的该消息
         * 参数3：处理消息的回调对象（接收到消息后，由该对象来处理）
         * 参数4：取消接收消息的回调对象
         */
        channel.basicConsume("welcome",true,deliverCallback,cancelCallback);
    }
}
