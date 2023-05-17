package com.utils.开发常用.JSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: yuanyinhuan
 * @date: 2021/10/26 16:46
 */
public class JsonMain {
    public static void main(String[] args) {

        String tr = "[http://10.0.31.7:9000/observatory/Dossen202210HuaDongReport.png,http://10.0.31.7:9000/observatory/Dossen202210HuaDongReport.png,http://10.0.31.7:9000/observatory/Dossen202210HuaDongReport.png]";
        String strip = StringUtils.strip(tr,"][");
        System.out.println(strip);


        List<String> strings = Arrays.asList(tr.split(","));
        System.out.println(strings);


        String str = "[{\"OFFLINEnum\":1,\"MTnum\":2,\"allnum\":4}]";

        Map<String, Object> map1 = JSON.parseObject(str, new TypeReference<Map<String, Object>>() {
        });



        JSONArray jsonArray= JSONArray.parseArray(str);
        System.err.println(jsonArray);

        List<MemberCurrentRealtime> list = jsonArray.toJavaList(MemberCurrentRealtime.class);
        for (MemberCurrentRealtime memberCurrentRealtime : list) {
            System.err.println(memberCurrentRealtime);
        }

        /**JSON.toJSONString 将对象转为JSON字符串*/
        MemberCurrentRealtime memberCurrentRealtime = new MemberCurrentRealtime();
        memberCurrentRealtime.setAllnum(1);
        memberCurrentRealtime.setMTnum(2);
        memberCurrentRealtime.setOFFLINEnum(3);
        String strJson = JSON.toJSONString(memberCurrentRealtime);
        /* {"allnum":1,"mTnum":2,"oFFLINEnum":3} */

        /*方案一:*/
        /**
         * 方案一:
         * JSON.parseObject 字符串转对象
         * JSON.parseArray 字符串转对象集合
         */
        MemberCurrentRealtime parseObject = JSON.parseObject(strJson, MemberCurrentRealtime.class);
        System.err.println(parseObject);

        String listStr = "[{\"OFFLINEnum\":1,\"MTnum\":2,\"allnum\":4},{\"OFFLINEnum\":3,\"MTnum\":9,\"allnum\":12}]";
        List<MemberCurrentRealtime> memberList = JSON.parseArray(listStr, MemberCurrentRealtime.class);
        System.err.println(memberList);

        /**
         * 方案二:
         * 1.先拿到JSONObject,再调用toJavaObject方法
         * 2.先拿到JSONArray,再调用toJavaArray方法
         */
        JSONObject jsonObject = JSONObject.parseObject(strJson);
        MemberCurrentRealtime memberCurrentRealtime1 = jsonObject.toJavaObject(MemberCurrentRealtime.class);

        JSONArray objects = JSONArray.parseArray(listStr);
        List<MemberCurrentRealtime> list1 = objects.toJavaList(MemberCurrentRealtime.class);


        HashMap<Object, Object> map = new HashMap<>();
        map.put("OFFLINEnum", 50);
        map.put("MTnum", 500);
        map.put("allnum", 5000);
        String s = JSON.toJSONString(map);
        System.err.println(s);



    }
}
