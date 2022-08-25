package com.utils.测试;

import com.utils.Bean.BeanDemo;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName DemoTest
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/7 17:29
 * @Version 1.0
 */
@SpringBootTest
public class DemoTest {

    @Test
    public void strSortDemo(){
        List<BeanDemo> list = new ArrayList<>();
        list.add(new BeanDemo("yyh", "18.555"));
        list.add(new BeanDemo("yyh10", "25.366"));
        list.add(new BeanDemo("yyh20", "8.2256"));
        System.out.println(list);
        List<BeanDemo> collect = list.stream().sorted(Comparator.comparing(BeanDemo::getAge)).collect(Collectors.toList());
        System.out.println(collect);
    }

}
