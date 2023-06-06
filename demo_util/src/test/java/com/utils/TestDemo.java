package com.utils;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/29
 */
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoUtilApplication.class)
public class TestDemo {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void demo001() {
        String body = restTemplate.getForEntity("http://10.0.31.16:8099/modelAndView", String.class).getBody();
        System.out.println(body);

        ModelAndView body1 = restTemplate.getForEntity("http://10.0.31.16:8099/modelAndView", ModelAndView.class).getBody();
        System.out.println(body);

    }

    @Test
    public void test001(){
        System.out.println(feibo01(45));
    }

    private int feibo(int n){
        if(n==0 ||n==1){
            return 1;
        }
        return feibo(n-1) + feibo(n-2);
    }

    private int feibo01(int n) {
        int p ,q=0,r=1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }

    @Test
    public void test02() {
        System.out.println(addBinary("1011", "1011"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        char c = a.charAt(0);

        int max = Math.max(a.length(), b.length()),count = 0;
        for (int i = 0; i < max; i++) {
            count += i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            count += i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            sb.append(count % 2);
            count /= 2;
        }

        // 表名最后是进位
        if (count > 0) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    @Test
    public void test003() {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }

        int min = 0;
        int max = x;

        while (max - min > 1) {
            int mid = (max+min)/2;
            if (x / mid < mid) {
                max = mid;
            } else{
                min = mid;
            }
        }

        return min;
    }


}
