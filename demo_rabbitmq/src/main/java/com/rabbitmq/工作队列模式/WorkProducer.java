package com.rabbitmq.工作队列模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.rabbitmq.utils.ConnRabbitMQUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class WorkProducer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel connRabbitMQ = ConnRabbitMQUtils.getConnRabbitMQ();

        /** 1.定义队列：如果队列不存在则新建、否则新建
         * 参数1：队列名
         * 参数2：是否是一个持久队列 (true:服务器重启不会消失；false:服务器重启会消失)
         * 参数3：是否是一个独占队列 (true:只能当前客户端使用；false:公共队列)
         * 参数4：是否自动删除 (true:没有消费者消费时自动删除)
         * 参数5：其他可配置参数
         */
        connRabbitMQ.queueDeclare("queueWork", true, false, false, null);

        while (true) {
            System.err.println("请输入消息：");
            String msg = new Scanner(System.in).nextLine();
            if ("exit".equals(msg)) {
                break;
            }

            /** 2.发送消息
             * 参数1：交换机名称：空串表示使用默认交换机direct
             * 参数2：队列名,指定发送消息的队列名
             * 参数3：消息持久化：（null:消息仅保存在内存中；）
             *                  MessageProperties.PERSISTENT_TEXT_PLAIN : 消息持久化
             * 参数4：字节数组,发送的消息
             */
            connRabbitMQ.basicPublish("", "queueWork", MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());

            System.err.println("消息发送成功 { " + msg + " }");
        }
        System.err.println("OVER");
        connRabbitMQ.close();
    }
}
