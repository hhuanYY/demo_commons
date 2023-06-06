package com.utils.http调用;

import com.alibaba.fastjson.JSON;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Demo_RestTemplate
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/10/16 15:36
 * @Version 1.0
 */
@Component
public class Demo_RestTemplate {


    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://cgi.dossen.com/data/template/access/134";
//        String url = "http://api01.idataapi.cn:8000/hotel/dossendata?id=0010002&appCode=ctrip&dataType=ctripbussiness&startDate=2022-09-22&endDate=2022-09-22&apikey=GYRtjWTrZhp217biFqJOuTz1Q02dBDhuax8Pubp72VygyZGyPr09kT11ObVLYs43";
//
//        // 使用getForObject()调用
//        String forObject = restTemplate.getForObject(url, String.class);
//        System.out.println(forObject);

        // 使用exchange()调用

        //请求头拼接（数据部提供的接口都需要这样）
        Map<String, String> params = new HashMap<>();
        params.put("bizday", "2022-09-22");
        ParamsRQ paramsRQ = new ParamsRQ(JSON.toJSONString(params));
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("App-Code", "ZC");
        headers.add("Access-Id", "JjVzCAGc");
        headers.add("Access-Key", "nJzDLdGy");
        HttpEntity<Object> req = new HttpEntity<>(paramsRQ,headers);

        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, req, new ParameterizedTypeReference<String>() {});
        System.out.println(exchange.getBody());
    }

    /**
     * 调用接口入参是@RequestParam的post请求
     */
    private void requestParam(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("mac","pool");

        ResponseEntity<String> exchange = new RestTemplate().exchange(
                "http://localhost:9099/get-order",
                HttpMethod.POST,
                new HttpEntity<>(request, httpHeaders),
                new ParameterizedTypeReference<String>() {
                }
        );
    }
}
