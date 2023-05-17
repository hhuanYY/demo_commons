package com.utils.api;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @ClassName ServletListenDemo
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/4/12 11:19
 * @Version 1.0
 */
@WebListener
public class ServletListenDemo implements HttpSessionListener {
    private static Integer count = 0;
    @Override
    public synchronized void sessionCreated(HttpSessionEvent se) {
        count++;
        System.out.println("用户上线了");
        se.getSession().getServletContext().setAttribute("count",count);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent se) {
        count--;
        System.out.println("用户下线了");
        se.getSession().getServletContext().setAttribute("count", count);
    }
}
