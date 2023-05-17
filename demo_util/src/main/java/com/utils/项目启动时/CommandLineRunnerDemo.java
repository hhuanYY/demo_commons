package com.utils.项目启动时;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 项目启动时，可执行的操作。run()方法中的操作，相当于是项目启动的一部分。
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/7
 */
@Component
public class CommandLineRunnerDemo implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("启动了...");
    }
}
