package com.utils.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName BeanDemo
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/13 20:10
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeanDemo {

    private String name;
    private String age;
    void  test() {
        System.out.println("我是method");
    }
}
