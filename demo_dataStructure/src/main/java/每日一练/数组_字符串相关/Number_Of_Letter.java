package 每日一练.数组_字符串相关;

/**
* @program: dataStructure
* @description: 字母出现的次数
* @author: 袁银欢
* @createTime: 2021/03/04 17:55
**/
public class Number_Of_Letter {
    public static void main(String[] args) {
        String str = "YYH Love XJH Forever";
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                arr[c - 'A']++;
            }
        }

        char c = 'A';
        for (int i : arr) {
                System.err.println(c++ +":"+ i);
        }
    }
}
