package com.utils.Redis监听key过期;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author: yuanyinhuan
 * @date: 2021/11/9 15:32
 */
public class KeyExpireListener extends KeyExpirationEventMessageListener {
    public KeyExpireListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {

    }
}
