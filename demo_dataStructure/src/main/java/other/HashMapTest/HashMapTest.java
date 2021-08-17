package other.HashMapTest;

import java.util.HashMap;
import java.util.Map;

/**
 * 散列表底层实现
 *   1. HashMap底层实现为散列表
 *   2. 散列表底层实现是数组，但是数组中存的是链表，链表中存的才是实际数据
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>(64);
        /**
         * 散列表工作原理：
         *  1. 当散列表中加入第一个元素{YYH=1}时,会将数组自动扩容一个长度为16长度
         *  2. 依据散列码值key("YYH")调用hashCode()方法并得到哈希码,通过哈希码在调用散列函数,即得到该元素锁存放的数组下标
         *
         *  3. 当第二个元素添加时,同样根据关键码至key("XJH"),得到哈希码，并通过哈希码调用散列函数，得到存放数据的数组下标
         *  4. 若该下标下正好存放了元素，则发生了散列冲突。
         *  5. 则需要调用equals()方法进行比较各个散列码值是否相等，若不等才可以添加
         *  6. 若有关键码值key相等，则后添加的数据会覆盖前面添加的数据
         *
         *  提前扩容： 当数组存入的数据长度 > 数组长度 * 负载因子(0.75) 时自动扩容
               优点： 防止散列冲突，散列冲突会减低 插入 和 查询效率
         *     缺点： 每一次扩容所有数据都会重新散列
         *
         *     解决办法： 在创建散列表时，就指定数组长度即可
         *       例如：  指定长度为64
         *
         *           Map<String,Integer> map = new HashMap<>(64);
         *
         */
        map.put("YYH",1);
        map.put("XJH",2);

    }
}
