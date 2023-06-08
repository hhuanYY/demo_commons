package com.utils.api.controller;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.http.HttpUtil;
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
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.time.Duration;
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

    @Autowired
    private DemoExcelCopy demoExcelCopy;

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
        try {
            Thread.sleep(3000);
            DemoExcelCopy bean = SpringUtil.getBean(DemoExcelCopy.class);
            System.out.println(bean);
            System.out.println("controller_start:"+Thread.currentThread().getName());
//        customizeService.asyncDemo01();
//        customizeService.asyncDemo02();
            System.out.println("controller_end:"+Thread.currentThread().getName());

        } catch (Exception e) {

        }

        return id;
    }

    @RequestMapping(value = "download",method = RequestMethod.GET)
    @ResponseBody
    public void downloadExcel(HttpServletResponse response) {
        try {
            /*告诉客户端接收响应的类型,并通过对应的方法解析*/
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            List<DemoExcel> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(new DemoExcel(i + "yyh", i));
            }
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            /*
               设置响应头,用于指示浏览器如何处理接收到的内容.
                   " Content-Disposition" 是 HTTP 响应头的一个字段，用于指定如何处理接收到的文件。
                    "attachment" 是 Content-Disposition 的一个参数，表示将文件作为附件下载。
                    "filename*=utf-8''" + fileName + ".xlsx" 是 Content-Disposition 的另一个参数，指定下载文件的名称。
                具体来说：
                    "filename*=utf-8''" 是告诉浏览器下载的文件名采用 UTF-8 编码。
                    fileName 是要下载的文件名，通常是一个动态生成的文件名。
                    ".xlsx" 是文件的扩展名，这里表示下载的文件是一个 Excel 文件。
                通过设置 Content-Disposition 头，浏览器会按照指定的方式处理文件。在这种情况下，浏览器会将接收到的文件作为附件下载，并将文件名设置为 fileName + ".xlsx"。
                请注意，设置 Content-Disposition 头只是向浏览器提供下载的建议，并不能保证浏览器一定按照这个方式处理文件。不同的浏览器可能会对 Content-Disposition 头的处理略有不同。
             */
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), DemoExcel.class).sheet("模板").doWrite(list);
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

    @RequestMapping(value = "requestTest", method = RequestMethod.GET)
    @ResponseBody
    public String requestTest() {

//        RestTemplate restTemplate = new RestTemplate();

        String s = null;
        try {
            s = HttpUtil.get("localhost:9099/api/async/11008", 2000);

//            SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
//            simpleClientHttpRequestFactory.setReadTimeout(5000);
//            simpleClientHttpRequestFactory.setConnectTimeout(5000);
//            restTemplate.setRequestFactory(simpleClientHttpRequestFactory);


            RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
            RestTemplate restTemplate = restTemplateBuilder
                    .setReadTimeout(Duration.ofSeconds(5))
                    .setConnectTimeout(Duration.ofSeconds(5))
                    .build();

            String forObject = restTemplate.getForObject("http://localhost:9099/api/async/1111", String.class);
            System.out.println(forObject);

        } catch (Exception e) {
            log.error("接口超时",e);
        }
        return s;
    }

}
