package com.utils.日常api.Lambda;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/8
 */
@FunctionalInterface
public interface Function<T,R> {
    R apply(T t);

}
