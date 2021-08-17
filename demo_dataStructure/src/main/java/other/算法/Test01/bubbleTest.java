package other.算法.Test01;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class bubbleTest {
    public static void main(String[] args) {
        int[] arr = {4,1,3,2,5};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.err.println(Arrays.toString(arr));
    }
}
