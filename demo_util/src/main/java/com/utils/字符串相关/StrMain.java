package com.utils.字符串相关;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

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


        /**
         * String.startsWith() 方法标识字符串是否以指定的前缀开始
         */
        String startStr = "/test";
        boolean b = startStr.startsWith("/");



        List<DataSupportParam> listStr = new ArrayList<>();
        DataSupportParam dataSupportParam1 = new DataSupportParam( "酒店id","hotelid","0020001" );
        DataSupportParam dataSupportParam2 = new DataSupportParam( "酒店id","hotelid","0020002,0020001" );
        listStr.add( dataSupportParam1 );
        listStr.add( dataSupportParam2 );

        for (DataSupportParam dataSupportParam : listStr) {
            dataSupportParam.setConditionName( method(dataSupportParam.getConditionName()) );
            dataSupportParam.setConditionField( method(dataSupportParam.getConditionField()) );
            dataSupportParam.setConditionValue( method(dataSupportParam.getConditionValue()) );
        }
        System.out.println( JSON.toJSONString( listStr ) );

    }

    /**
     * 给值单独拼接 ''
     * @param value
     * @return
     */
    public static String method(String value) {
        List<String> listStr = new ArrayList<>();
        String[] split = value.split( "," );
        for (String str : split) {
            listStr.add( "'" + str + "'" );
        }
        String join = StringUtils.join( listStr,"," );
        return join;
    }
}
