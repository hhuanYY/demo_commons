package other.算法.Test;

/**
 * 计算一个字符串中存在指定子串的次数
 *  例如： String str = "i love the world,all the world,world..."; 出现子串'world'的次数
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "i love the world,all the world,world,world,world,world,world...";
        String subStr = "world";
        int count = 0,index = -1;
        while ((index = str.indexOf(subStr,index)) != -1){
            count++;
            index += subStr.length();
        }
        System.err.println("world出现的次数为："+ count);
    }
}
