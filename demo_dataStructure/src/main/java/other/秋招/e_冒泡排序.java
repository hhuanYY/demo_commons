package other.秋招;

import java.util.Arrays;

public class e_冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {5,8,9,3,12,6};
        for (int i =1; i<arr.length;i++){
            for (int j = 0; j < arr.length-i; j++){
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.err.println(Arrays.toString(arr));
    }
}
