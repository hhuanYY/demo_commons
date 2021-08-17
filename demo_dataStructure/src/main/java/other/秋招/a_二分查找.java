package other.秋招;

import java.util.Arrays;
import java.util.Random;

/**
 *  1. 查找100个随机数中最大的前10个,并按照循序排列显示
 *         使用Arrays的binarySearch()方法
 */
public class a_二分查找{
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for(int i = 0; i < 100; i++){
            int sum = random.nextInt(1000);
            // index：指的是-(应该添加的下标)-1
            int index = Arrays.binarySearch(arr,sum);
            // 不需要处理的两种情况：idnex = 0：刚好等于数组的最小值, index = 1：比最小值更小
            if(index == 0 || index == -1)
                continue;
            // 把idnex处理为应当添加到的下标
            if(index < 0)
                index = -(index+1);
            // 把后一个数的值赋值给前面一个数,目的是移除最小值
            for (int j = 1; j < index; j++){
                arr[j-1] = arr[j];
            }
            arr[index -1] = sum;
        }
        System.err.println(Arrays.toString(arr));
    }
}
