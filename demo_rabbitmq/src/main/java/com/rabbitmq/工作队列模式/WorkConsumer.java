package com.rabbitmq.工作队列模式;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.utils.ConnRabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class WorkConsumer {
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

        DeliverCallback deliverCallback = (s,delivery)-> {
            byte[] body = delivery.getBody();
            int index = 0;
            for (byte point : body) {
                if ("46".equals(String.valueOf(point))) {
                    index++;
                }
            }

            try {
                long start = System.currentTimeMillis();
                Thread.sleep(index * 1000);
                long end = System.currentTimeMillis();

                // 手动确认：消息A处理完后,给队列发送处理成功回执
                /**
                 * 参数1：消息对应的标签
                 * 参数2：是否确认多条消息（false:每次只确认一条信息；true：确认之前收到过的所有消息）
                 */
                connRabbitMQ.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
                System.err.println("消息接收完成,共耗时" + (end - start) / 1000.0 + "s, { " + new String(body) + " }");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };


        CancelCallback cancelCallback = s -> {

        };

        // 合理分发：每次接收一条信息，并且只有消息处理完后，才继续接收消息
        connRabbitMQ.basicQos(1);


        /** 2.接收消息
         * 参数1：队列名（从指定队列中消费消息）
         * 参数2：是否自动确认（true:自动确认后,无论消息是否消费完，都会不停地轮询分发消息并直接删除队列中的该消息）
         *                   false:手动确认,消息未消费完时，队列不会删除掉该消息，只有消费者回传了成功处理的响应后才会删除队列中的该消息
         * 参数3：处理消息的回调对象（接收到消息后，由该对象来处理）
         * 参数4：取消接收消息的回调对象
         */
        connRabbitMQ.basicConsume("queueWork", false, deliverCallback, cancelCallback);

    }
}
