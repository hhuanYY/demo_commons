package com.utils.api.controller.redisson;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/6/8
 */
public interface DemoRedisson {
   <V,T> RedisDemo<V> getDemo(T t);
}
