package other.算法;

/**
 * 题目：
 * 统计一个字符串中，小写字母出现的次数
 */
public class charAt {
    public static void main(String[] args) {
        String str = "欢欢123fagtabcHuanoopYYHloveXjh";
        //定义长度为26的数组,用于存放所有的小写字母
        int[] arr = new int[26];
        //遍历字符串
        for (int i=0; i<str.length(); i++){
            //取出字符串中的每一个字符
            char c = str.charAt(i);
            if (c>='a' && c<='z'){
                //得到当前字符c 所在数组的下标
                arr[c - 'a']++;
            }
        }
        char c = 'a';
        for(int i : arr){
            System.err.println(c++ +"出现的次数为："+ i);
        }
    }
}
