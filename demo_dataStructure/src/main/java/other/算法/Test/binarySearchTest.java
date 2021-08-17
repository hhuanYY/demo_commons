package other.算法.Test;

import java.util.Arrays;
import java.util.Random;

/**
 *  假设100个随机生成数，找出其中最大的5个
 */
public class binarySearchTest {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Random random = new Random();
        for (int i=0; i<100; i++){
            int num = random.nextInt(1000);
            int index = Arrays.binarySearch(arr,num); // 获取index表示： -'应该添加的与元素'-1
            if (index == 0 || index == -1){ //添加的元素正好等于数组最小元素更小或者更小
                continue;
            }
            if (index < 0) {
                index = -(index + 1); // 获得idnex为整数的实际下标
            }
            for (int j = 1; j < index; j++) {
                // 挪出数组中最小的元素，即：下标为0的数。 将数组元素后一位赋值给前一位即可实现
                arr[j - 1] = arr[j];
            }
            //需要将新元素插入到目标数组中,此时index应当添加到的下标,但是由于数组最小元素已经移除，所以得 -1
            arr[index - 1] = num;
            System.err.println(num);
            System.err.println(Arrays.toString(arr));
        }
    }
}
