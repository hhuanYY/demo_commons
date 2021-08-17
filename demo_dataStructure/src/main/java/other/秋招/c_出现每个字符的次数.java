package other.秋招;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class c_出现每个字符的次数 {
    public static void main(String[] args) {
        String str = "hello hanhan,hello world huan,hello";
        Map<Character,Integer> map = new HashMap<>();
        Set<Character> set = map.keySet();
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++){
            if (set.contains(c[i])){
                map.put(c[i],map.get(c[i])+1);
            } else {
                map.put(c[i],1);
            }
    }
        System.err.println(map);
    }
}
