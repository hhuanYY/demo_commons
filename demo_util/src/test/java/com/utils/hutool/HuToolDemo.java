package com.utils.hutool;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.lang.id.NanoId;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.utils.DemoUtilApplication;
import com.utils.api.controller.DemoExcel;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/6/6
 */
@SpringBootTest(classes = DemoUtilApplication.class)
public class HuToolDemo {

    @Test
    public void getAllTools() {
        List<DemoExcel> list = new ArrayList<>();
        DemoExcel demoExcel = new DemoExcel("yyh", 25);
        System.out.println(JSONUtil.toJsonStr(demoExcel));

        String str = "[{\"username\":\"yyh\",\"age\":25},{\"username\":\"yyh\",\"age\":25},{\"username\":\"yyh\",\"age\":25}]";

        List<DemoExcel> list1 = JSON.parseArray(str, DemoExcel.class);

//        System.out.println(JSONUtil.toBean(str, DemoExcel.class));
//        JSONArray objects = JSONUtil.parseArray(str);
//        for (Object object : objects) {
//            list.add((DemoExcel) object);
//        }
        List<DemoExcel> list2 = JSON.parseObject(str, new TypeReference<List<DemoExcel>>() {
        });


//        FIFOCache<String, Integer> fifoCache = CacheUtil.newFIFOCache(5);
//        fifoCache.put("test",128,1000);
//        fifoCache.put("person", 910);
//        System.out.println(fifoCache);
////        System.out.println(fifoCache.get("test"));
//        System.out.println(fifoCache.prune());
//        System.out.println(fifoCache);
//
//        BitMapBloomFilter bitMap = BloomFilterUtil.createBitMap(100);
//        bitMap.add("stream1");
//
//        System.out.println(bitMap.contains("stream"));


//        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(400, 400);
//        System.out.println(lineCaptcha.createImage("SMT"));
//
//
//        SensitiveUtil.init(Collections.singletonList("kiss"));
//        System.out.println(SensitiveUtil.containsSensitive("kiss"));


//        DemoExcel sourceBean = new DemoExcel("test", 188);
//        DemoExcelCopy targetBean = BeanUtil.toBean(sourceBean, DemoExcelCopy.class);
//        System.out.println(targetBean);
//
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("username","test");
//        map.put("age", 188);
//
////        /*将Map中的内容填充至Bean中*/
////        DemoExcelCopy demoExcelCopy = new DemoExcelCopy();
////        CglibUtil.fillBean(map, demoExcelCopy);
//
//        /*将Map转化为Bean*/
//        DemoExcelCopy excelCopy = BeanUtil.toBean(map, DemoExcelCopy.class);
//
//        System.out.println(BeanUtil.toBean(map, DemoExcelCopy.class));
//
//        List<DemoExcel> sourceList = Collections.singletonList(new DemoExcel("test", 188));
//        List<DemoExcelCopy> targetList = BeanUtil.copyToList(sourceList, DemoExcelCopy.class);
//        System.out.println(targetList);

//        DemoExcelCopy bean = SpringUtil.getBean(DemoExcelCopy.class);
//        System.out.println(bean);
//
//        HttpUtil.createGet("localhost:")

//        List<DemoExcel> list3 = CollUtil.emptyIfNull(new ArrayList<>());
//        System.out.println(list3);
//
//        List<String> source = new ArrayList<>();
//        source.add("A");
//        source.add("B");
//        source.add("C");
//        source.add("D");
//        System.out.println(CollUtil.contains(source, "A"));
//        CollUtil.join(source, ",");

//        System.out.println(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));


//        System.out.println(DateUtil.formatLocalDateTime(LocalDateTime.now()));
//        DateUtil.format(LocalDateTime.now(), DatePattern.NORM_DATETIME_PATTERN);
//        LocalDateTime start = LocalDateTimeUtil.parse("2023-06-05 00:00:00", DatePattern.NORM_DATETIME_PATTERN);
//        LocalDateTime end = LocalDateTime.now();
//        List<String> dataList = new ArrayList<>();
//        while (!start.isAfter(end)) {
//            dataList.add(LocalDateTimeUtil.format(start.toLocalDate(), DatePattern.NORM_DATE_PATTERN));
//            start = start.plusDays(1);
//        }
//        System.out.println(dataList);

        System.out.println(NanoId.randomNanoId(6));
        System.out.println(NanoId.randomNanoId());
        Map<Integer, String> test = MapUtil.of(123, "test");

        String string = UnicodeUtil.toString("\u0000");
        String unicode = UnicodeUtil.toUnicode("1");

        System.out.println("这是一个字符串 \"dd\"");
        System.out.println("这是换行符 \n");
        System.out.println("这是制表符 \t");
        System.out.println("这是反斜杠 \\\\ ");

        Snowflake snowflake = IdUtil.getSnowflake();
        System.out.println(snowflake.nextId());

    }

}
