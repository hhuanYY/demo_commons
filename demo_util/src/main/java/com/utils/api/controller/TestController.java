package com.utils.api.controller;

import com.utils.api.FieldDemo;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/13 19:11
 * @Version 1.0
 */
@Controller
public class TestController {

    @RequestMapping(value = "/api/test",method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Object> getTest(){

        FieldDemo fieldDemo = new FieldDemo();
        fieldDemo.setUSER_NAME("yyh");
        fieldDemo.setPASSWORD("123");
//        fieldDemo.setAGe(24);
        fieldDemo.setCreateTIME(new Date());

        return new HttpEntity<>(fieldDemo);
    }
}
