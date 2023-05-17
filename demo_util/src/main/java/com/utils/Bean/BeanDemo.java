package com.utils.Bean;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @ClassName BeanDemo
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/13 20:10
 * @Version 1.0
 */
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BeanDemo {

    private String name;
    private String age;
    void  test() {
        System.out.println("我是method");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
