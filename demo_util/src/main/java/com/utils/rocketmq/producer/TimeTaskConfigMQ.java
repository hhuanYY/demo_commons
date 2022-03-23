package com.utils.rocketmq.producer;

import com.alibaba.fastjson.JSON;
import com.utils.rocketmq.Family;
import com.utils.rocketmq.User;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author: yuanyinhuan
 * @date: 2021/9/1 14:46
 */
// 启动类里面使用@EnableScheduling 注解开启功能，开启自动扫描；
@EnableScheduling
@Component
public class TimeTaskConfigMQ {

    /**
     * @PostConstruct : 项目启动时调用一次
     * @Scheduled : 添加在需要执行的定时方法上，接下来描述一下@Scheduled参数的具体定义
     * 1、fixedDelay和fixedRate，单位是毫秒；
     * 区别：fixedRate---,每多少毫秒执行一次，与具体业务执行时间没关系；而fixedDelay是当任务执行完毕后按照设定的毫秒值执行任务。所以根据实际业务不同，我们会选择不同的方式。
     * 2、cron表达式：依据业务需求，可设定具体的任务执行时间，预定时间一到就会自动执行；
     * cron一共有7位，但是最后一位是年，可以留空，一般情况可以写6位：
     * * 第一位，表示秒，取值0-59
     * * 第二位，表示分，取值0-59
     * * 第三位，表示小时，取值0-23
     * * 第四位，日期天/日，取值1-31
     * * 第五位，日期月份，取值1-12
     * * 第六位，星期，取值1-7，星期一，星期二...，注：不是第1周，第二周的意思
     * 另外：1表示星期天，2表示星期一。
     * * 第7为，年份，可以留空，取值1970-2099
     * 3、cron中，还有一些特殊的符号，含义如下：
     * (*)星号：可以理解为每的意思，每秒，每分，每天，每月，每年...
     * (?)问号：问号只能出现在日期和星期这两个位置。
     * (-)减号：表达一个范围，如在小时字段中使用“10-12”，则表示从10到12点，即10,11,12
     * (,)逗号：表达一个列表值，如在星期字段中使用“1,2,4”，则表示星期一，星期二，星期四
     * (/)斜杠：如：x/y，x是开始值，y是步长，比如在第一位（秒） 0/15就是，从0秒开始，每15秒，最后就是0，15，30，45，60
     * 4、举例描述cron:
     * 0 0 8 * * ?     每天8点执行
     * 0 30 8 * * ?    每天8点30分执行
     * 0 30 5 ? * *    每天8点30分执行，与上面作用相同，区别特殊符号
     * 0 5/5 8 * * ?   每天8点的 5分，10分，15分，20分，35分，40分，45分，50分，55分这几个时间点执行
     * 0 30 8 ? * 1    每周星期天，8点30分 执行，注：1表示星期天
     * 0 30 8 ? * 1#3  每个月的第三个星期，星期天执行，#号只能出现在星期的位置
     * ————————————————
     * 原文链接：https://blog.csdn.net/qq_41144667/article/details/103795004
     * <p>
     * 测试用例:
     * cron = "0 0 * 2 * ?"    每一个月二号的每个整点小时执行一次
     * cron = "8 9 10 2 * ?"   每一个月二号的10点9分8秒执行一次
     * <p>
     * cron = "0 0 9-12 2 * ?" 每一个月二号的9点至12点执行一次
     * cron = "0 0 * 2-5 * ?"  每个月二号至五号的每个整点执行一次
     */

    @Autowired
    private DefaultMQProducer defaultMQProducer;


    @Scheduled(cron = "0 03 18 * * ?")
    public void MQTest() throws Exception {

        List<Family> list = new ArrayList<>();
        Family family = new Family("xxy","son");
        list.add(family);
        User user = new User("yyh",100,"beijing",list);

        Message message = new Message("ROCKETMQ_SERVICE_TEST_TOPIC", "tag", JSON.toJSONBytes(user));

        /**
         *  添加额外的消息属性，设置后消费者能够能够这个属性来过滤消息 (例如：只消费age=18的消息)
         *     例如: defaultMQPushConsumer.subscribe(topicAndTag[0], MessageSelector.bySql("age > 16"))
         */
        message.putUserProperty("age", "18");

        try {

            /**
             *  1. 该模式默认是同步消息: (即时性较强,需要立马得到发送消息后的回执。例如：短信、通知(转账成功))
             */
            SendResult send = defaultMQProducer.send(message);


            /**
             *  2. 异步消息: 除了传一个message,还需要一个回调函数: (即时性较弱，也需要回执，但是回执可以后续缓慢返回)
             */
            defaultMQProducer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    // 发送成功的响应
                }

                @Override
                public void onException(Throwable e) {
                    // 发送失败的响应
                }
            });

            /**
             *  3. 单向消息，不需要回执 (不需要回执，例如日志系统)
             */
            defaultMQProducer.sendOneway(message);

            /**
             * 4. 延时消息: 通过设置消息的延时等级来实现 (消息发送时并不直接发送到消息服务器上，而是根据设定的等待时间到达，起到延时到达的缓冲作用)
             */
            message.setDelayTimeLevel(3);
            defaultMQProducer.send(message);

            /**
             * 5. 批量消息: 将多个单条消息封装到集合中,集中起来一次性发送 (批量消息需要主要一次性消息大小<4M)
             */
            List<Message> messageList = new ArrayList<>();
            messageList.add(message);
            defaultMQProducer.send(messageList);


            System.err.println("写入消息队列成功: "+message);
        } catch (Exception e) {
            System.err.println("写入消息队列失败");
        }

    }
}
