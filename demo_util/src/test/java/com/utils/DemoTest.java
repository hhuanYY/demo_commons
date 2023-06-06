package com.utils;

import cn.hutool.extra.spring.SpringUtil;
import com.utils.Bean.BeanDemo;
import com.utils.Bean.DemoService;
import com.utils.多线程.ThreadDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @ClassName DemoTest
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/7 17:29
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoUtilApplication.class)
public class DemoTest {

    private void fieldDemo(List<Integer> list) {
        list.add(100);
    }

    private void fieldDemo(Integer list1) {
    }

    private String fieldDemo(String str) {
        return "";
    }


    @Test
    public void fieldTest() {
        List<Integer> list = new ArrayList<>(Collections.singletonList(50));
        fieldDemo(list);
        System.out.println(list);
    }


    @Test
    public void objectDemo() {
        BeanDemo s1 = new BeanDemo("yyh", "18.555");
        BeanDemo s2 = new BeanDemo("yyh", "18.555");

        System.out.println(s1 + " : " + s1.hashCode());
        System.out.println(s2 + " : " + s2.hashCode());
        System.out.println(s1.equals(s2));

    }


    @Test
    public void strSortDemo() {
        List<BeanDemo> list = new ArrayList<>();
        list.add(new BeanDemo("yyh", "18.555"));
        list.add(new BeanDemo("yyh10", "25.366"));
        list.add(new BeanDemo("yyh20", "8.2256"));
        System.out.println(list);
        List<BeanDemo> collect = list.stream().sorted(Comparator.comparing(BeanDemo::getAge)).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void threadDemo() {
        System.out.println(Thread.currentThread().getName());
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();
        Thread thread = new Thread(threadDemo);
        thread.start();
    }

    @Test
    public void runnableDemo() {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }


    @Test
    public void callableDemo() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });

        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

    @Test
    public void executorDemo() {
        Executors.newFixedThreadPool(5);
    }

    @Test
    public void threadLocalDemo() {
        CopyOnWriteArrayList<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("1");
        copyOnWriteArrayList.get(0);
    }

    @Test
    public void regexDemo() {
        // 正则表达式
        String regex = ".[35789]\\d{9}";
        String str = "*9627785960";
        System.out.println(str.matches(regex));

        Pattern compile = Pattern.compile(regex);
        System.out.println(compile.matcher(str).matches());

        //邮箱正则
        String regexMail = "\\w{5,10}@gmail\\.com";
        String mail = "hhua1111@gmail.com";
        System.out.println(mail.matches(regexMail));

        // 0086 或者 +86 开头的正则
        String regexRegion = "(0086|\\+86)\\s1[35789]\\d{9}";
        System.out.println("+86 18627785960".matches(regexRegion));
    }

    @Test
    public void demo() {
        int i = 10;
        int j = ++i;
        System.out.println(j);
    }

    @Test
    public void demoString() {
        String str = "yyhhello;yyhxjh";
        String regex = "yyh";
        int num = 0;
        int len = -1;
        while ((len = str.indexOf(regex, len)) != -1) {
            num++;
            len += regex.length();
        }
        System.out.println(num);

    }


    @Test
    public void strString() {
        String str = "abCddEfghiIjK";
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (Character.isUpperCase(str.charAt(i))) {
                sb.append(Character.toLowerCase(str.charAt(i)));
            } else {
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
        }
        System.out.println(sb.toString());
    }

    // 反转一个数字
    @Test
    public void numReverseDemo() {
        // 	输入: 123
        //	输出: 321

        //	输入: -123
        //	输出: -321

        //	输入: 120
        //	输出: 21
        int num = -123;
        int target = 0;
        while (num != 0) {
            target = target * 10 + num % 10;
            num /= 10;
        }

        if (target > Integer.MAX_VALUE || target < Integer.MIN_VALUE) {
            target = 0;
        }

        System.out.println(target);
        System.out.println(1 / 10);
    }

    // 判断数字是否为回文
    @Test
    public void numDemo() {
        int num = 112211;
        int oldNum = num;
        int newNum = 0;

        if (num < 0 || num > Integer.MAX_VALUE) {
            System.out.println(num + "：不是回文数");
        }

        while (num > 0) {
            newNum = newNum * 10 + num % 10;
            num /= 10;
        }
        if (newNum > Integer.MAX_VALUE || newNum < Integer.MIN_VALUE) {
            System.out.println(num + "：不是回文数");
        }

        if (oldNum == newNum) {
            System.out.println(oldNum + "==" + newNum + "：是回文数");
        }

    }

    @Test
    public void strDemo() {
        StringBuilder target = new StringBuilder();
        StringBuilder sb = new StringBuilder("YhjTcdYGdJj");
        sb.reverse();
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isUpperCase(sb.charAt(i))) {
                target.append(Character.toLowerCase(sb.charAt(i)));
            } else {
                target.append(Character.toUpperCase(sb.charAt(i)));
            }
        }
        System.out.println(target);
    }

    // 判断有效的括号  ([{}])--true   {[][}-false
    @Test
    public void stackDemo() {
        String str = "()[{()}](";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            // 如果为开括号，则入栈
            if (charAt == '{' || charAt == '[' || charAt == '(') {
                stack.push(charAt);
            } else {
                Character pop = stack.pop();
                switch (charAt) {
                    case '}':
                        if (pop != '{') {
                            System.out.println("不是有效括号");
                        }
                        break;
                    case ']':
                        if (pop != '[') {
                            System.out.println("不是有效括号");
                        }
                        break;
                    case ')':
                        if (pop != '(') {
                            System.out.println("不是有效括号");
                        }
                        break;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("是有效括号");
        } else {
            System.out.println("不是有效括号");
        }
    }

    @Test
    public void enumDemo() {
        DemoEnum year = DemoEnum.valueOf("YEAR");
        System.out.println(year.name());
        System.out.println(year.getName());
        System.out.println(year.getCode());
        for (int i = DemoEnum.values().length - 1; i >= 0; i--) {
            
        }
        System.out.println();
    }

    // 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
    @Test
    public void targetDemo() {
        int[] intArr = {2,4,6,7,9};
        int target = 9;
        for (int i = 0; i < intArr.length; i++) {
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[i] + intArr[j] == target) {
                    System.out.println(i+","+j);
                }
            }
        }
    }

    @Test
    public void nineDemo() {
        for (int i = 1; i <= 9; i++) {
            for (int j = i; j <= 9; j++) {
                System.out.print(i + "*" + j + "=" + i * j + " ");
            }
            System.out.println();
        }
    }


    @Test
    public void test01() {
        System.out.println("xxx");
        Map<String, DemoService> hashMap= SpringUtil.getBeansOfType(DemoService.class);
        System.out.println(hashMap);
    }

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void demo001() {
        String body = restTemplate.getForEntity("http://10.0.31.16:8099/modelAndView", String.class).getBody();
        System.out.println(body);

        ModelAndView body1 = restTemplate.getForEntity("http://10.0.31.16:8099/modelAndView", ModelAndView.class).getBody();
        System.out.println(body);

    }



}
