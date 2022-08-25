package com.utils.api.controller;

import com.utils.Bean.BeanDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/13 19:11
 * @Version 1.0
 */
@Controller
public class TestController {

    @Autowired
    private BeanDemo beanDemo;

    @RequestMapping(value = "/api/test",method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<Object> getTest(){
        return new HttpEntity<>("OK");
    }
}
