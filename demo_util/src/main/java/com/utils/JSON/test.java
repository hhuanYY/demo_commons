package com.utils.JSON;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author: yuanyinhuan
 * @date: 2021/10/26 16:46
 */
public class test {
    public static void main(String[] args) {
        String str = "[{\"OFFLINEnum\":1,\"MTnum\":2,\"allnum\":4}]";
        JSONArray jsonArray= JSONArray.parseArray(str);
        System.err.println(jsonArray);

        List<MemberCurrentRealtime> list = jsonArray.toJavaList(MemberCurrentRealtime.class);
        for (MemberCurrentRealtime memberCurrentRealtime : list) {
            System.err.println(memberCurrentRealtime);
        }


    }
}
