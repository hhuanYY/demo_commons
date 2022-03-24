package com.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuanyinhuan
 * @date: 2022/3/3 17:31
 */
public class Test {
    public static void main(String[] args) throws Exception {


//        String str = "1.45";
//        double v1 = Double.parseDouble(str);
//        double v2 = 0.35;
//        if (v1 > v2) {
//            System.err.println("0.45 > 0.35");
//        }
//
        List<String> hotelList = new ArrayList<>();
        hotelList.add("0020001");
        hotelList.add("0020002");
        hotelList.add("0020003");

        List<String> indexCodeList = new ArrayList<>();
        indexCodeList.add("index_occ");
        indexCodeList.add("index_adr");

        List<TestDemo> successStore = new ArrayList<>();

        for (String hotel : hotelList) {
            for (String indexCode : indexCodeList) {
                //1. 查询某个酒店对应的指标值
                TestValue value = methods01(hotel, indexCode);
                if ("index_occ".equals(indexCode)) {
                    if (Double.parseDouble(value.getValue()) > new Double(0.50)) {
                        TestDemo testDemo = new TestDemo(hotel, indexCode);
                        successStore.add(testDemo);
                    }

                } else if ("index_adr".equals(indexCode)) {
                    if (Double.parseDouble(value.getValue()) > new Double(50)) {
                        TestDemo testDemo = new TestDemo(hotel, indexCode);
                        successStore.add(testDemo);
                    }

                }
            }
        }

        System.err.println(successStore);


    }

    private static TestValue methods01(String hotel, String indexCode) {
        return new TestValue("0020001", "0.58");
    }


}
