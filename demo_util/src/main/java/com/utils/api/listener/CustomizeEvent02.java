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
public class CustomizeEvent02 extends ApplicationEvent {

    private final Integer id;

    public CustomizeEvent02(Object source, Integer id) {
        super(source);
        this.id = id;
        System.out.println("ID_event");
    }


    public Integer getId() {
        return id;
    }
}
