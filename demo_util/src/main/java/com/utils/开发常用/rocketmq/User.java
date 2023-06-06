package com.utils.开发常用.rocketmq;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: yuanyinhuan
 * @date: 2022/3/23 17:14
 */
@Data
@NoArgsConstructor
@Builder
public class User {
    private String username;
    private Integer age;
    private String address;
    private List<Family> familyList;

    public User(String username, Integer age, String address, List<Family> familyList) {
        this.username = username;
        this.age = age;
        this.address = address;
        this.familyList = familyList;
    }
}
