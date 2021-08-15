package com.rabbitmq.路由模式;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import com.rabbitmq.utils.ConnRabbitMQUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class RoutingConsumer01 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel connRabbitMQ = ConnRabbitMQUtils.getConnRabbitMQ();
        // 1.消费者创建交换机
        connRabbitMQ.exchangeDeclare("routingModel", "direct");
        // 2.创建队列
        String queueName = connRabbitMQ.queueDeclare().getQueue();
        // 3.绑定
        System.err.println("请输入路由键, 可写多个并按照逗号分割: ");
        String routingList = new Scanner(System.in).nextLine();
        String[] routingKeys = routingList.split(",");
        for (String routingKey : routingKeys) {
            /** 绑定队列与交换机
             * 参数1：队列名
             * 参数2：交换机名
             * 参数3：路由键(生产者设置)
             */
            connRabbitMQ.queueBind(queueName, "routingModel", routingKey);
        }

        DeliverCallback deliverCallback = (s, delivery) -> {
            String msg = new String(delivery.getBody());
            String routingKey = delivery.getEnvelope().getRoutingKey();
            System.err.println("消息接收成功: "+ msg + " : " +routingKey);
        };

        CancelCallback cancelCallback = s -> {

        };

        /** 2.接收消息
         * 参数1：队列名（从指定队列中消费消息）
         * 参数2：是否自动确认（true:自动确认后,无论消息是否消费完，都会不停地轮询分发消息并直接删除队列中的该消息）
         *                   false:手动确认,消息未消费完时，队列不会删除掉该消息，只有消费者回传了成功处理的响应后才会删除队列中的该消息
         * 参数3：处理消息的回调对象（接收到消息后，由该对象来处理）
         * 参数4：取消接收消息的回调对象
         */
        connRabbitMQ.basicConsume(queueName, true, deliverCallback, cancelCallback);

    }
}
