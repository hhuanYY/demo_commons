package com.rabbitmq.发布订阅模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.utils.ConnRabbitMQUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class PubsubProducer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel connRabbitMQ = ConnRabbitMQUtils.getConnRabbitMQ();
        // 创建交换机 参数1：交换机自定义民称   参数2：交换机类型
        connRabbitMQ.exchangeDeclare("lombok", "fanout");

        while (true) {
            System.err.println("请输入发送消息：");
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
            connRabbitMQ.basicPublish("lombok","",null,msg.getBytes());
            System.err.println("发送成功: " + msg);
        }

        connRabbitMQ.close();

    }
}
