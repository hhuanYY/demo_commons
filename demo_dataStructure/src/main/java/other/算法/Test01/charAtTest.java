package other.算法.Test01;

import java.util.Arrays;

/**
 * 找出一个字符串中,所有数字出现的次数
 *      String str = "52000000000憨憨abcABC^";
 */
public class charAtTest {
    public static void main(String[] args) {
        String str = "52000000000憨憨abcABC^";
        int[] arr = new int[10];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); //取出字符串中的每一个字符
            if (c >= '0' && c <= '9') {
                arr[c - '0']++;
            }
        }
        System.err.println(Arrays.toString(arr));
        char c = '0';
        for (int i : arr){
            System.err.println(c++ +"出现的次数为："+i);
        }
    }
}
