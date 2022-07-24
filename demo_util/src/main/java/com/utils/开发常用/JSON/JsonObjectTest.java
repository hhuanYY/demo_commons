package com.utils.开发常用.JSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * @author: yuanyinhuan
 * @date: 2022/1/6 16:21
 */
public class JsonObjectTest {
    public static void main(String[] args) {
        String str = "{'$str$':'IFNULL......'}";

        JSONObject jsonObject = JSONObject.parseObject(str);

        String string = jsonObject.getString("$str$");
        System.err.println(string);

        String sql = "[{INDEX_ADR:156.02923,INDEX_OCC:0.63527}]";
        // 可直接是用new TypeReference<Map<String, Object>>() {} 封装为map对象
        Map<String, Object> map = JSON.parseObject(sql, new TypeReference<Map<String, Object>>() {});

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.err.println(key);
            System.err.println(value);
        }


        //JSONObject 转化为 具体对象
        JSONObject jo = new JSONObject();
        //方案1:
        Object o1 = JSON.toJavaObject(jo, Object.class);
        //方案2:
        Object o2 = jo.toJavaObject(Object.class);


        //JSONArray 转化为 具体对象集合
        JSONArray ja = new JSONArray();
        List<Object> objects = ja.toJavaList(Object.class);


    }
}
