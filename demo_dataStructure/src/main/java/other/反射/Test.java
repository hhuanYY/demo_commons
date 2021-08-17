package other.反射;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {
    public static void main(String[] args) {
        //1. 获取并输入类的名称
        Class mClass = SonClass.class;
        System.err.println(mClass.getName());

        //2. 获取所有本类中变量(包括父类,且只能是public权限)
        Field[] fields = mClass.getFields();
        for(Field field : fields){
            //2.1 获取访问权限并输出
            int modifiers = field.getModifiers();
            System.err.print(Modifier.toString(modifiers) + ":");
            //2.2 输出变量的类型和变量名
            System.err.println(field.getType().getName() + field.getName());


            System.err.println("=================");

            //获取方法信息
            Method[] methods = mClass.getMethods();
            for(Method method : methods){
                int modifier = method.getModifiers();
                System.err.print(Modifier.toString(modifier)+" ");
                // 获取方法的返回值类型
                Class returnType = method.getReturnType();
                System.err.println(returnType.getName() +" "+ method.getName());
                // 获取方法中参数
            }
        }    }
}
