package com.utils.Java进阶基础.反射;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射：
 * 1. Java独有的特性, 支持对.class字节码文件进行剖析
 * 2. 具体能够解析出: .class字节码文件包含的(属性、方法(构造方法、公有/私有方法、注解)
 */
public class DemoReflect {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 1. 检查类上是否有注解
//        Class<?> forName = Class.forName("com.utils.Java进阶基础.反射.DemoRef");
//        forName.getAnnotation(DemoAnnotation.class);
//        Annotation[] declaredAnnotations = forName.getDeclaredAnnotations();
//        for (Annotation declaredAnnotation : declaredAnnotations) {
//            System.out.println(declaredAnnotation);
//        }

        Class<?> name = Class.forName("com.utils.Java进阶基础.反射.Ref");
        Ref ref = (Ref) name.newInstance();
        //通过反射获取到这个对象的所有方法名称
        Method[] declaredMethods = name.getDeclaredMethods();

        /*通过放射访问对象中的私有方法: 并赋值操作; 私有方法使用反射访问的应用列举: 应用软件加密*/
        /*获取对象中某个方法, 参数1:方法名,可变参数的个数取决于这个对象的这个方法有几个参数*/
        Method setSign = name.getDeclaredMethod("setSign", Integer.class);
        /* 1.根据方法名以及方法上使用的参数类型,调用getDeclaredMethod 获得Method对象*/
        Method md5 = name.getDeclaredMethod("md5", String.class, String.class);
        /* 2.调用setAccessible()并传入true,标识该方法设置为允许访问私有方法, 解除private的限制*/
        md5.setAccessible(true);
        /* 3.调用invoke()方法来处理逻辑,传入改方法属于的对象引用, 以及该方法需要传入的参数值*/
        Object yyh = md5.invoke(ref, "YYH", "123");
        System.out.println(yyh);

    }
}


