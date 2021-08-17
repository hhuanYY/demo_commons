package 每日一练.数组_字符串相关;

/**
* @program: dataStructure
* @description:

* @author: 袁银欢
* @createTime: 2021/03/03 17:21
**/

public class Number_Reverse {
    public static void main(String[] args) {
        int x = 123;
        System.err.println(reverse(x));
    }

    private static int reverse(int x) {
        /**
         *  通过对目标值x重复取余，来反转目标值
         */
        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return -1;
        }
        return rev;
    }

}
