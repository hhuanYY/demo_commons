package com.utils.api.controller;

import com.utils.UserDemo;
import com.utils.api.FieldDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/13 19:11
 * @Version 1.0
 */
@Controller
@Slf4j
public class TestController {

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/api/test{id}", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Object> getTest(@PathVariable("id") Integer id) {
        FieldDemo fieldDemo = new FieldDemo();
        fieldDemo.setUSER_NAME("yyh-get");
        fieldDemo.setPASSWORD(String.valueOf(id));
        fieldDemo.setCreateTIME(new Date());
        return new HttpEntity<>(fieldDemo);
    }




    @RequestMapping(value = "/api/thread/get", method = RequestMethod.GET)
    @ResponseBody
    public String testThread(HttpServletRequest request, @RequestParam("id") Integer id) {
//        ThreadPoolTaskExecutor executor = threadPool.getThreadPoolTaskExecutor();
//        for (int i = 0; i < 20; i++) {
//            int finalI = i;
//            executor.execute(() -> {
//                System.out.println(finalI + ":" + Thread.currentThread().getName());
//            });
//        }
        log.error("order:{} sync to huijia fail {}", "is a error", "big error","");
        System.out.println(String.format("order:{} sync to huijia fail {}", "is a error", "big error"));
        return "[get]当前在线人数：" + request.getSession().getServletContext().getAttribute("count") + "------" + id;
    }

    @RequestMapping(value = "/get-order",method = RequestMethod.POST)
    @ResponseBody
    public String getOrder(@RequestParam(name = "mac") String mac){
        return mac + " : " + UUID.randomUUID();
    }

    @RequestMapping(value = "/getOrder",method = RequestMethod.GET)
    @ResponseBody
    public String get(){
        HttpHeaders httpHeaders = new HttpHeaders();
        // 定义请求头Content-Type类型
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        // 必须使用MultiValueMap<>封装被@RequestParam()注解修饰的参数
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("mac","pool");

        ResponseEntity<String> exchange = restTemplate.exchange(
                "http://localhost:9099/get-order",
                HttpMethod.POST,
                new HttpEntity<>(request, httpHeaders),
                new ParameterizedTypeReference<String>() {
                }
        );
        String body = exchange.getBody();
        return body;
    }

    @RequestMapping(value = "/api/thread/post", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> testPost(@RequestBody UserDemo userDemo) {
        Map<String, Object> map = new HashMap<>();
        map.put("yyh-post", userDemo);
        return map;
    }


    @RequestMapping(value = "/modelAndView", method = RequestMethod.GET)
    public ModelAndView getModelAndView(){
//        ModelAndView view = new ModelAndView("redirect:" + "http:127.0.0.1:8099");
//        System.out.println(view);
//        System.out.println(JSON.toJSONString(view));
        return new ModelAndView("redirect:" + "https://www.baidu.com/?tn=62095104_27_oem_dg&ch=1");
    }


    @RequestMapping(value = "/modelAndViewTest", method = RequestMethod.GET)
    public String demo001() {
        String body = restTemplate.getForEntity("http://10.0.31.16:9099/api/thread/get?id=550", String.class).getBody();
        System.out.println(body);

        return "";
    }

    @RequestMapping(value = "/modelAndViewTest001", method = RequestMethod.GET)
    public String demo002() throws IOException {
        // 使用getForEntity()方法，且使用String来封装ModelAndView类型接口返回的信息
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:9099/modelAndView", String.class);
        // 获取返回的重定向地址
        URI uri = forEntity.getHeaders().getLocation();
        System.out.println(forEntity.getHeaders().getLocation());
        return "";
    }
}
