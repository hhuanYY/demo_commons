package com.utils.api.listener;

import org.springframework.context.ApplicationEvent;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/26
 */
public class CustomizeEvent extends ApplicationEvent {

    private final String str;

    public CustomizeEvent(Object source, String str) {
        super(source);
        this.str = str;
        System.out.println("STR_event");
    }

    public String getStr() {
        return str;
    }

}
