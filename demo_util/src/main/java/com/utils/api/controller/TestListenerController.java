package com.utils.api.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import com.utils.api.listener.CustomizeEvent;
import com.utils.api.listener.CustomizeEvent02;
import com.utils.api.service.CustomizeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/31
 */
@Controller
@Slf4j
public class TestListenerController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CustomizeService customizeService;

    @RequestMapping(value = "/api/listener/{str}", method = RequestMethod.GET)
    @ResponseBody
    public String testListener(@PathVariable("str") String str) {
        System.out.println("STR_controller_start");
        CustomizeEvent customizeEvent = new CustomizeEvent(this,str);
        applicationContext.publishEvent(customizeEvent);
        System.out.println("STR_controller_end");
        return str;
    }

    @RequestMapping(value = "/api/listener02/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Integer testListener02(@PathVariable("id") Integer id) {
        System.out.println("ID_controller_start");
        CustomizeEvent02 customizeEvent02 = new CustomizeEvent02(this, id);
        applicationContext.publishEvent(customizeEvent02);
        System.out.println("ID_controller_end");
        return id;
    }

    @RequestMapping(value = "/api/async/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Integer asyncTest(@PathVariable("id") Integer id) {
        System.out.println("controller_start:"+Thread.currentThread().getName());
        customizeService.asyncDemo01();
        customizeService.asyncDemo02();
        System.out.println("controller_end:"+Thread.currentThread().getName());
        return id;
    }

    @RequestMapping(value = "download",method = RequestMethod.GET)
    @ResponseBody
    public void downloadExcel(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            List<DemoExcel> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(new DemoExcel(i + "yyh", i));
            }
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), DemoExcel.class).sheet().doWrite(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "readExcel", method = RequestMethod.POST)
    @ResponseBody
    public String readExcel(@RequestParam("file") MultipartFile file) {
        try {

            EasyExcel.read(file.getInputStream(), DemoExcel.class, new ReadListener<DemoExcel>() {
                // 定义每批次入库的条数
                private final Integer COUNT_LINE = 3;
                private List<DemoExcel> list =  ListUtils.newArrayListWithExpectedSize(COUNT_LINE);

                // 每行数据解析都会来调用一次
                @Override
                public void invoke(DemoExcel demoExcel, AnalysisContext analysisContext) {
                    list.add(demoExcel);
                    log.info("读取一条数据成功: {}", JSON.toJSONString(demoExcel));
                    if (list.size() >= COUNT_LINE) {
                        // 清空列表,进入下一批
                        log.info("入库一批数据成功: {}", JSON.toJSONString(list));
                        list = ListUtils.newArrayListWithExpectedSize(COUNT_LINE);
                    }
                }

                // 当所有数据解析完,调用一次
                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                    // 需要在调用一次入库方法,避免最后一次结果不满数据条数 而没有入库
                    log.info("最后一次入库成功:{}", JSON.toJSONString(list));
                    log.info("所有数据解析完毕!");
                }
            }).sheet().doRead();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "所有数据解析完毕";
    }

}
