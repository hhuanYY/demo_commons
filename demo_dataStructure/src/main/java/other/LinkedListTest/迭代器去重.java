package other.LinkedListTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: dataStructure 
 * @ClassName: 迭代器去重
 * @Author: YYH
 * @Description:   
 * @CreateDate: 2021/6/10 11:06
 */
public class 迭代器去重 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(3);
        list.add(4);


//        // list 转存为 set 实现去重
//        Set<Integer> set = new HashSet<>(list);
//        list.clear();
//        list.addAll(set);
//        System.err.println(list);


        // 迭代器 遍历 - 去重
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            System.err.println(next);
//            if (next == 4) {
//                iterator.remove();
//            }
//        }


//        String str = "1 2 3 45";
//        // 通过 ""分隔； 且仅仅分为两份
//        String[] s = str.split(" ",2);
//        for (int i = 0; i < s.length; i++) {
//            System.out.println(s[i]);
//        }

        // 替换空格
        String str = "1 2 3 4 5";
        System.err.println(str == null ? null : str.replaceAll(" ", "&"));
    }
}
