package com.utils;

import com.utils.annotation.TestAnnotation;
import com.utils.反射.Teacher;
import com.utils.常用工具.输入日志模板.Desc;
import com.utils.常用工具.输入日志模板.DescEnum;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName DataSourceDemo
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/3/31 8:48
 * @Version 1.0
 */
@SpringBootTest
public class DataSourceDemo {
    @Test
    public void waterFlower() {
        // 求100-1000以内的水仙花数 153 =1*1*1 +5*5*5 +3*3*3
        int sum = 0;
        for (int i = 100; i <= 1000; i++) {
            int num = 0;
            int j = i;
            while (j > 0) {
                int t = j%10;
                num += t*t*t;
                j /=10;
                if (num == i) {
                    sum ++;
                    System.out.println("每个水仙花数："+num);
                }
            }
        }
        System.out.println("总共水仙花数："+sum);
    }

    @Test
    public void childrenStr() {
        // 求子串出现的次数
        String str ="yyhxjg;;yyh;xdm;yyh__duiipp;";
        String childrenStr = "x";
        int len = -1;
        int num = 0;
        while ((len = str.indexOf(childrenStr, len)) != -1) {
            num ++;
            len += childrenStr.length();
        }
        System.out.println("子串出现的次数："+num);
    }

    @Test
    public void maoPaoSort() {
        // 冒泡排序
        int[] sort = {5,4,9,6,3};
        for (int i = 0; i < sort.length-1; i++) {
            for (int j = 0; j < sort.length-1 - i; j++) {
                if (sort[j] > sort[j + 1]) {
                    int t = sort[j];
                    sort[j] = sort[j + 1];
                    sort[j + 1] = t;
                }
            }
        }

        System.out.println(Arrays.toString(sort));

        for (int i = 10; i > 1; i--) {
            System.out.println(i);
        }
    }

    @Test
    public void hashDemo() {
        String key = "yyh";
        int h;
        System.out.println((h = key.hashCode()) ^ h >>> 16);
    }


    @Test
    public void demo() {
        for (int i = 1; i <= 9;i++ ) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i + "*" + j + "=" + i * j+" ");
            }
            System.out.println("");
        }
    }

    // 水仙花数 153 = 1*1*1 + 5*5*5 + 3*3*3 求0-1000以水仙花数
    @Test
    public void flowDemo() {
        int num = 0;
        for (int i = 100; i < 1000; i++) {
            int n1 = i;
            int sum = 0;
            while (n1 > 0) {
                int t = n1%10; // 右到左拿到每一位的值
                sum += t*t*t; // 每次循环累加
                n1 /= 10;
                if (sum == i) {
                    num ++;
                    System.out.println(sum);
                }
            }
        }
        System.out.println("出现次数："+num);
    }

    @Test
    public void strDemo() {
        String str = "hellodflkagjasldkhellodsfsd;;hello;;dsfjcdcdsff;;;;";
        int len = -1;
        int num = 0;
        String targetStr = "hello";
        while ((len = str.indexOf(targetStr, len)) != -1) {
            num ++;
            len += targetStr.length();
        }
        System.out.println("子串出现次数：" + num);
    }

    @Test
    public void buDemo() {
        int[] data = {5, 8, 4, 1, 6, 3, 7};
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j + 1] > data[j]) {
                    int t = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = t;
                }
            }
        }

        System.out.println(Arrays.toString(data));
    }

    @Test
    public void feiboDemo() {
        System.out.println(feibo(10));
    }

    private int feibo(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return feibo(n - 1) + feibo(n - 2);
        }
    }


    @Test
    public void sumDemo() {
        int i = 513;
        StringBuilder sb = new StringBuilder();
        strD(i, sb);
        System.out.println(sb.toString());
    }

    private void strD(int i, StringBuilder sb) {
        if (i < 10) {
            sb.append(i);
        } else {
            sb.append(i % 10);
            strD(i / 10, sb);
        }
    }

    @Test
    public void demo01() {
        int num = 111;
        method01(num);
    }

    private void method01(int num) {
        if (num>5000){
            System.out.println("程序停止");
            return;
        }
        System.out.println(num);
        method01(2*num);
    }

    @Test
    public void demo02() {

        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }

        System.out.println(method02(8));
    }

    private int method02(int num) {
        if (num == 1) {
            return 10;
        } else {
            return method02(num - 1) + num;
        }
    }


    @Test
    public void strSort01() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 5, 2, 6, 3, 8, 7));
        System.out.println(quickSort(list));
    }

    private List<Integer> quickSort(List<Integer> arr){
        // 结束条件 数组大小为1
        if (arr.size() <= 1) {
            return arr;
        }
        Integer first = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < arr.size() ; i++) {
            if (arr.get(i) < first) {
                left.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }

        List<Integer> result = quickSort(left);
        result.add(first);
        result.addAll(quickSort(right));
        return result;
    }

    @Test
    public void demo06() {
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 2, 6, 5));
        System.out.println(method06(list));
    }

    private List<Integer> method06(List<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }
        Integer first = arr.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < first) {
                left.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }

        List<Integer> result = method06(left);
        result.add(first);
        result.addAll(method06(right));
        return result;
    }

    @Test
    public void classDemo() {

        Teacher teacher = new Teacher(new BigDecimal("1000000"), new BigDecimal("0.80"), new BigDecimal("266"));

        Field[] fields = Teacher.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            TestAnnotation annotation = field.getAnnotation(TestAnnotation.class);
            if (Objects.isNull(annotation)) {
                continue;
            }


            try {
                System.out.println(field.get(teacher));

                System.out.println(annotation.isIndex());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void descDemo() {
        Desc desc = new Desc(DescEnum.ADD);
        System.out.println(desc.addDemo());

    }

    @Test
    public void fileDemo() {
        File file = new File("D:\\QMDownload");
        File[] files = file.listFiles();
        printFile(files);
    }
    private static int num = 0;

    private void printFile(File[] files) {
        if (Objects.isNull(files)) {
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件：" + ++num + "-----：" + file.getName());
            } else if (file.isDirectory()){
                printFile(file.listFiles());
            }
        }

    }





}
