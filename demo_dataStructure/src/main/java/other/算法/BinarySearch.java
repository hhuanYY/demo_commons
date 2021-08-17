package other.算法;

import java.util.Arrays;
import java.util.Random;

/**
 * 题目：
 * 从大量数据中找出前100个数 --- 等价抓换成： 从100个随机数中找到前5个（最大的5个）
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0};
        Random random = new Random();
            for (int i=0; i<10; i++){
            int num = random.nextInt(100);
            //得到新元素添加大数组中的下标位置,index为 '-应该添加道的下标'-1
            int index = Arrays.binarySearch(arr,num);
            //index=0 表示新元素正好和数组最小元素相等  idnex=-1表示新元素比数组最小元素还要小
            if (index == 0 || index == -1){
                continue;
            }
            //将index转换成 实际应该添加到的下标
            if (index < 0){
                index = -(index+1);
            }
            for (int j=1; j<index; j++){
                //将数组中最小值挪出
                arr[j-1] = arr[j];
            }
            //实际添加下标 = 应该添加下标-1 应该数组最小挪出了
            arr[index - 1] = num;
            System.err.println(num);
            System.err.println(Arrays.toString(arr));
        }
    }
}
