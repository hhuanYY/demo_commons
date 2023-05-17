import effective_java.page3.ComparableDemo;
import effective_java.page3.ComparableDemoChild;

import java.util.*;

/**
 * @ClassName DemoTest
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/12/13 15:54
 * @Version 1.0
 */
public class DemoTest {
    public static void main(String[] args) {

        System.out.println(String.join("-", new String[]{"111", "2233"}));

        Object str = "123";
        if (str instanceof String) {
            System.out.println("\t"+str);
        }

        System.out.println("开始...");
        throwsDemo();
        System.out.println("结束...");

        setPair(new ArrayList<>());

        setDemoo(Collections.singletonList(new ComparableDemoChild()));

    }

    public static int throwsDemo(){
        int i = 1,j=0;
        int result = 0;
        try {
            result =  i / j;
        } catch (Exception e) {
            System.out.println("异常_+"+e.getMessage());
        }
        return result;
    }


    public static void setPair(List<? extends Comparable> list) {

    }

    void setDemo(List<? super Object> list) {}

    static void setDemoo(List<? super ComparableDemo> list){};

    String getDemo(){return "";};


    private void fieldDemo(List<Integer> list){
        list.add(100);
    }

    private void fieldDemo(Integer list1){
    }

    private String fieldDemo(String str) {
        return "";
    }

}
