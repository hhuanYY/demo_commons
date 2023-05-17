package effective_java.page2;

/**
 * @ClassName 用静态工厂方法代替构造器
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/1/2 15:08
 * @Version 1.0
 */
public class 用静态工厂方法代替构造器 {

    public static String str;

    public static void main(String[] args) {
        Demo demo = new Demo();


    }

    public static DemoFather staticDemo(){
        return new Demo();
    }

    public void demo(){
        String substring = str.substring(0);
        用静态工厂方法代替构造器.staticDemo();
    }

}
