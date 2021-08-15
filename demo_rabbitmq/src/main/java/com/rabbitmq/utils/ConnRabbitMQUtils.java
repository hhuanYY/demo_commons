package com.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnRabbitMQUtils {
    public static Channel getConnRabbitMQ() throws IOException, TimeoutException {
        /**
         * 1.创建链接工厂,并设置对应的链接信息
         */
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");

        // 指定虚拟主机名称
        //  connectionFactory.setVirtualHost("/");

        // 建立链接
        Connection conn = connectionFactory.newConnection();
        // 在链接中,创建一个信道. 通过信道来发送信息
        Channel channel = conn.createChannel();

        return channel;
    }
}
