package com.utils.开发常用.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ProjectName：demo_commons
 * @ClassDesc：
 * @Author：yyhuan
 * @CreateTime：2022/6/16
 */
public class RQ {

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    public static void main(String[] args) throws Exception{
//        // 构造Producer时，必须指定groupId
//        DefaultMQProducer producer = new DefaultMQProducer("my_producer_group");
//        // 只用namesrv的地址就行，它会从namesrv上拿到broker的地址和topic信息
//        producer.setNamesrvAddr("10.0.31.116:9876;10.0.31.117:9876");
//        producer.start();
//
//        int num = 0;
//        while (num < 20) {
//            num++;
//            /**
//             * rocketmq封装了Message
//             * String topic,
//             * String tags, 标签（分类）---> 筛选
//             * byte[] body
//             */
//            Message message = new Message("my_test_topic", "", ("hello rocketmq:" + num).getBytes());
//            // 发送消息，拿到返回SendResult
//            SendResult result = producer.send(message);
//            System.out.println(result);
//        }



    }
}
