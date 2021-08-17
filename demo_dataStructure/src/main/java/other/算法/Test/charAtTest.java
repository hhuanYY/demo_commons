package other.算法.Test;

/**
 * 一串字符串中找到 小写字母的次数！
 */
public class charAtTest {
    public static void main(String[] args) {
        String str = "ABCabcXYZxyz10086憨憨Coooooooooool";
        //创建一个长度为26的数组,用于装所有的小写字母
        int[] arr = new int[26];
        //遍历字符串
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); //取出每一个字符
            if (c >= 'a' && c <= 'z'){
            arr[c - 'a']++;
        }

        }
        char x = 'a';
        for (int t : arr){
            System.err.println("第"+ x++ +"个字符串出现的次数为："+ t);
        }
    }
}
