package com.utils.Bean.utils;

import org.apache.logging.log4j.message.ParameterizedMessage;

/**
 * @Author：Mr_Wan
 * @CreateTime：2021/7/8
 */
public class ParamUtil {

    /**
     * 动态参数设置
     * @param string 字符串
     * @param objects 参数
     * @return 字符串
     */
    public static String formatString(String string,Object... objects) {
        return new ParameterizedMessage(string,objects).getFormattedMessage();
    }

}
