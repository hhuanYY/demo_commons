package com.utils.开发常用.占位符替换;

import java.text.MessageFormat;

/**
 * @ProjectName：demo_commons
 * @ClassDesc：
 * @Author：yyhuan
 * @CreateTime：2022/7/13
 */
public class MessageFormatTest {

    public static void main(String[] args) {
        String sql = " {0} BETWEEN  {1} AND  {2} ";
        String format = MessageFormat.format( sql,"tableA.bizDay","20210201","20220201" );
        System.out.println( format );
        }

}
