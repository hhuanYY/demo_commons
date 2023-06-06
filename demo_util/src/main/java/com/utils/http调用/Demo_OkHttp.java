package com.utils.http调用;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName demo_okhttp
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/10/16 15:36
 * @Version 1.0
 */
public class Demo_OkHttp {

    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)  //设置连接超时时间
                .readTimeout(1, TimeUnit.SECONDS)   //设置读取超时时间
                .build();

        String url = "http://api01.idataapi.cn:8000/hotel/dossendata?id=0010002&appCode=ctrip&dataType=ctripbussiness&startDate=2022-09-22&endDate=2022-09-22&apikey=GYRtjWTrZhp217biFqJOuTz1Q02dBDhuax8Pubp72VygyZGyPr09kT11ObVLYs43";

        // okhttp--GET请求
        Request requestGet = new Request.Builder()
                .url(url)
                .get()
                .build();
        final Call callGet = okHttpClient.newCall(requestGet);
        Response executeGet = callGet.execute();
        String result = Objects.requireNonNull(executeGet.body()).string();
        String data = JSON.parseObject(result).getString("data");
        System.out.println(data);


        // okhttp--POST请求
        // Java解决方案: 使用create(String,MediaType) 代替 过时的create(MediaType,String)
        Map<String, String> params = new HashMap<>();
        params.put("bizday", "2022-09-22");
        ParamsRQ paramsRQ = new ParamsRQ(JSON.toJSONString(params));

        RequestBody requestBody = RequestBody.create(String.valueOf(paramsRQ),MediaType.parse("application/json; charset=utf-8"));
        String urlPost = "http://cgi.dossen.com/data/template/access/134";
        Map<String, String> map = new HashMap<>();
        map.put("App-Code", "ZC");
        map.put("Access-Id", "JjVzCAGc");
        map.put("Access-Key", "nJzDLdGy");
        Request requestPost = new Request.Builder()
                .url(urlPost)
                .post(requestBody)
                .headers(Headers.of(map))
                .build();
        final Call callPost = okHttpClient.newCall(requestPost);
        Response executePost = callPost.execute();
        System.out.println(Objects.requireNonNull(executePost.body()).string());


    }
}
