package com.utils.字符串相关;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuanyinhuan
 * @date: 2021/12/2 16:14
 */
public class StrMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.add("23");
        list.add("24");
        list.add("55");

        /** join用于将集合结果用自定义符号分隔[仅限于List集合]*/
        String join = String.join(",", list);
        System.err.println(join);

        /** format用于字符串常规格式化
         * 1.   "小超" 替换 第一个%s
         * 2.   "今年" 替换 第二个%s
         * 3.   18  替换 %d
         *
         *  %s	字符串类型	“喜欢请收藏”
         *  %c	字符类型	‘m’
         *  %b	布尔类型	true
         *  %d	整数类型（十进制）	88
         *  %x	整数类型（十六进制）	FF
         *  %o	整数类型（八进制）	77
         *  %f	浮点类型	8.888
         *  %a	十六进制浮点类型	FF.35AE
         *  %e	指数类型	9.38e+5
         */
        String format = String.format("HI %s %s %d", "小超", "今年", 18);
        System.err.println(format);

    }
}
