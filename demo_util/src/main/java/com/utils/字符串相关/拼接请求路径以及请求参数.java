package com.utils.字符串相关;

import com.utils.utils.ParamUtil;

/**
 * @author: yuanyinhuan
 * @date: 2022/3/2 10:46
 */
public class 拼接请求路径以及请求参数 {

    /**
     * ParamUtil.formatString()
     *     将参数params按照{}的先后顺序,并将Object... 每一个动态参数按顺序放置到params中的每一个{}中
     * @param args
     */
    public static void main(String[] args) {
        String path = "http://dc150.com";
        String params = "?id={}&dataType={}&option={}&startDate={}&endDate={}&apikey={}&test={}";
        path = path+ ParamUtil.formatString(params,"0020001","Y","PLAY","20220222",20220223,"API_KEY","XXT");
        System.err.println(path);
    }
}
