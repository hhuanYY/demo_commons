package com.utils.开发常用.rocketmq;

import lombok.Data;
import lombok.ToString;

/**
 * @author: yuanyinhuan
 * @date: 2022/3/23 17:17
 */
@Data
@ToString
public class Family {
    private String familyName;
    private String familyType;

    public Family(String familyName, String familyType) {
        this.familyName = familyName;
        this.familyType = familyType;
    }
}
