package other.算法;
/**
 * 判断一个字符串中出现 'world'的次数
 */
public class indexOfTest {
    public static void main(String[] args) {
        String str = "i love the world,world is my home,world,world,world !";
        String subStr = "world";
        int count = 0,index = -1;
        while ((index = str.indexOf(subStr,index)) != -1){
            count++;
            index += subStr.length();
        }
        System.err.println(count);
    }
}