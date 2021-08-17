package other.算法.Test01;

import java.util.Arrays;
import java.util.Random;

/**
 * 找到100个随机数中最大的前五个
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(100);
            int index = Arrays.binarySearch(arr,num);
            if (index == 0 || index == -1){
                continue;
            }
            if (index < 0){
                index = -(index + 1);
            }
            for (int j = 1; j < index; j++) {
                arr[j - 1] = arr[j];
            }
            arr[index - 1] = num;
            System.err.println(num);
            System.err.println(Arrays.toString(arr));
        }
    }
}
