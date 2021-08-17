package other.Works;

/**
 * 面试题： 统计下列字符串中 "world"出现的次数？
 *          String str = "helloworld,i love world,all the world";
 *
 *          思路： 使用indexOf(String str,int index)方法来查找是否出现  'world'字符串
 *                      1.若出现,则返回值一定不为 -1
 *                      2.每次找到一个 'world'后,下标 加 'world'的长度,再继续查找
 *
 */
public class IndexOfTest {

    public static void main(String[] args) {

        String str = "helloworld,i love World,all the world,worldHanHan,World";
        String str1 = str.toLowerCase();
        String sub = "world";
        int index = -1;
        int count = 0;
        while((index = str1.indexOf(sub,index)) != -1){
            count++;
            index += sub.length();
        }
        System.err.println("world出现的次数为:"+count);
    }

}
