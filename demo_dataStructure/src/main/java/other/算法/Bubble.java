package other.算法;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubble {
    public static void main(String[] args) {
        int[] arr = {8,5,4,7,9};
        //快速排序
        System.err.println("排序前："+ Arrays.toString(arr));
        sort(arr);
        print(arr);
    }

    private static void sort(int[] arr) {
        for (int i =1; i < arr.length; i++){
            for (int j = 0; j < arr.length - i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    private static void print(int[] arr) {
        System.err.println("排序后：" + Arrays.toString(arr));
    }
}
