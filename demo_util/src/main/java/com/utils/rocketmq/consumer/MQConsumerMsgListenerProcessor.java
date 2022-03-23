package com.utils.rocketmq.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.utils.rocketmq.Family;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author: yuanyinhuan
 * @date: 2022/3/23 11:27
 */
@Component
public class MQConsumerMsgListenerProcessor implements MessageListenerConcurrently {

    @Value("${dossen.rocketmq.consumer.topics}")
    private String topicAndTag;

    /**
     * 默认msg里只有一条消息,可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
     * 不要抛异常,如果没有return CONSUME_SUCCESS,consumer会重新消费该消息,直到return CONSUME_SUCCESS
     */
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> messageExtList, ConsumeConcurrentlyContext context) {
        if (CollectionUtils.isEmpty(messageExtList)) {
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        MessageExt messageExt = messageExtList.get(0);

        // 判断消息中的topic和tag和本地配置是否一致
        boolean result =  consumerHandle(topicAndTag,messageExt);
        if (result) {
            byte[] body = messageExt.getBody();
            String s = new String(body, StandardCharsets.UTF_8);

            JSONArray familyList = JSON.parseObject(s).getJSONArray("familyList");
            List<Family> families = familyList.toJavaList(Family.class);
            System.err.println("接收到消息: "+families);
        }

//        // 首先将字符串的响应转成JSONObject类型,然后获取到该响应中某个key对应的value值(核心响应对象)
//        JSONObject object = JSON.parseObject(s).getJSONObject("key");
//        // 最后将拿到的核心响应对线转化为具体的实体类
//        Object o = JSON.toJavaObject(object, Object.class);

        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }


    private boolean consumerHandle(String topicAndTag,MessageExt messageExt){
        boolean result = false;
        String[] query = topicAndTag.split(":");
        if (query[0].equals(messageExt.getTopic())) {
            if ("*".equals(query[1])) {
                result = true;
            } else if (messageExt.getTags().equals(query[1])) {
                result = true;
            }
        }

        return result;
    }
}
