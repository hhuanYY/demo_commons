package com.rabbitmq.路由模式;

import com.rabbitmq.client.Channel;
import com.rabbitmq.utils.ConnRabbitMQUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class RoutingProducer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel connRabbitMQ = ConnRabbitMQUtils.getConnRabbitMQ();
        // 生产者创建交换机
        connRabbitMQ.exchangeDeclare("routingModel", "direct",Boolean.TRUE);

        while (true) {
            System.err.println("请输入发送消息: ");
            String msg = new Scanner(System.in).nextLine();
            if ("exit".equals(msg)) {
                break;
            }

            System.err.println("请输入路由键: ");
            String routingMsg = new Scanner(System.in).nextLine();


            /** 2.发送消息
             * 参数1：交换机名称：空串表示使用默认交换机direct
             * 参数2：路由键：根据路由键来匹配     (简单模式和工作模式可用队列名来匹配,指定发送消息的队列名)
             * 参数3：消息持久化：（null:消息仅保存在内存中；）
             *                  MessageProperties.PERSISTENT_TEXT_PLAIN : 消息持久化
             * 参数4：字节数组,发送的消息
             */
            connRabbitMQ.basicPublish("routingModel",routingMsg,null,msg.getBytes());
            System.err.println("发送成功: " + msg);
            System.err.println("-------------------------------");
        }

    }
}
