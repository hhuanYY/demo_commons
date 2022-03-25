package com.utils;

import lombok.Data;

/**
 * @author: yuanyinhuan
 * @date: 2022/3/24 9:57
 */
@Data
public class TestValue {
    private String hotelId;
    private String value;

    public TestValue(String hotelId, String value) {
        this.hotelId = hotelId;
        this.value = value;
    }
}
