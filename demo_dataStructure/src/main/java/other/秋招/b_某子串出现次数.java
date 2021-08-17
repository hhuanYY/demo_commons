package other.秋招;

public class b_某子串出现次数 {
    public static void main(String[] args) {
        String str = "hello hanhan,hello world huan,hello";
        String subStr = "hello";
        int count = 0,index = -1;
        while ((index = str.indexOf(subStr,index)) != -1){
            index += subStr.length();
            count++;
        }
        System.err.println(count);
    }
}
