package com.utils;

import com.utils.开发常用.rocketmq.Family;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDemo {
    private String username;
    private Integer age;
    private String address;
    private List<Family> familyList;

}
