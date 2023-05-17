package effective_java.page9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName 迭代器
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/2/12 21:50
 * @Version 1.0
 */
public class 迭代器 {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        System.out.println(arrayList);

        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            iterator.remove();
        }

        arrayList.toArray(new Object[0]);


    }
}
