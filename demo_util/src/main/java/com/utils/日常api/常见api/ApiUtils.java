package com.utils.日常api.常见api;

import java.text.DecimalFormat;

/**
 * @ProjectName：demo_commons
 * @ClassDesc：
 * @Author：yyhuan
 * @CreateTime：2022/4/2
 */
public class ApiUtils {
    public static void main(String[] args) {


        /**
         * 使用0占位符的时候：
         * 1、 比实际数字的位数多，不足的地方用0补上。
         * 2、 比实际数字的位数少：整数部分不改动，小数部分，四舍五入（其实并不是四舍五入
         */
        Integer num = 306;
        DecimalFormat decimalFormat = new DecimalFormat("00.00");
        System.err.println(decimalFormat.format( num ));


        String str = "000004";
        System.err.println(Integer.valueOf( str ) + 1);
//
//        Objects.isNull( "" );
//        Joiner.on( " and " ).join( List );
//        StringUtils.join( List," and " );

    }
}
