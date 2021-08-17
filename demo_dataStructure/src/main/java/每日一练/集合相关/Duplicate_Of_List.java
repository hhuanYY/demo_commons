package 每日一练.集合相关;

import java.util.ArrayList;
import java.util.List;

/**
* @program: dataStructure
* @description: 集合去重
* @author: 袁银欢
* @createTime: 2021/03/05 14:45
**/
public class Duplicate_Of_List {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(2);
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = list.size()-1; j > i; j--) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(i);
                }
            }
        }
//        System.err.println(list);

        List<String> list1 = new ArrayList<>();
        list1.add("yyh");
        list1.add("xjh");

        if (list1.contains("yyh")) {
            System.err.println("----------1");
        }

    }

}
