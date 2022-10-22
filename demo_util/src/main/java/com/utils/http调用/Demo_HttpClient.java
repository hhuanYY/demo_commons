package com.utils.http调用;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

/**
 * @ClassName demo_httpclient
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/10/16 15:36
 * @Version 1.0
 */
public class Demo_HttpClient {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClientBuilder = HttpClientBuilder.create().build();
        String url = "http://api01.idataapi.cn:8000/hotel/dossendata?id=0010002&appCode=ctrip&dataType=ctripbussiness&startDate=2022-09-22&endDate=2022-09-22&apikey=GYRtjWTrZhp217biFqJOuTz1Q02dBDhuax8Pubp72VygyZGyPr09kT11ObVLYs43";
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse execute = httpClientBuilder.execute(httpGet);
        System.out.println(execute.getEntity());
    }
}
