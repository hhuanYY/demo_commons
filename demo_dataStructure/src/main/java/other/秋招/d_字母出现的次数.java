package other.秋招;

public class d_字母出现的次数 {
    public static void main(String[] args) {
        String str = "hello hanhan,hello world huan,hello";
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c >='a' && c <= 'z')
                arr[c - 'a']++;
        }
        char c = 'a';
        for(int i : arr) {
            System.err.println(c++ +"出现次数为："+i);
        }
    }
}
