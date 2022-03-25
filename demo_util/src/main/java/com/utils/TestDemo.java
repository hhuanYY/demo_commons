package com.utils;

import lombok.Data;

/**
 * @author: yuanyinhuan
 * @date: 2022/3/24 9:51
 */
@Data
public class TestDemo {
    private String hotel;
    private String indexCode;

    public TestDemo(String hotel, String indexCode) {
        this.hotel = hotel;
        this.indexCode = indexCode;
    }
}
