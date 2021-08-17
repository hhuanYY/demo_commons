package 每日一练.数组_字符串相关;


/**
* @program: dataStructure
* @description: 
* @author: 袁银欢
* @createTime: 2021/03/03 18:08
**/
public class Str_Str {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.err.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null) {
            return -1;
        }

        char x = needle.charAt(0);
        char[] c1 = haystack.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == x) {
                return i;
            }
        }
        return -1;
    }
}
