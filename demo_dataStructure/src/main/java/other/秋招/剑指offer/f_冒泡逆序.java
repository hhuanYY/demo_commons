package other.秋招.剑指offer;

import java.util.Arrays;

public class f_冒泡逆序 {
    public static void main(String[] args) {

        int[] arr = {1,6,3,2};
        for (int i = 1; i < arr.length; i++){
            for (int j = 0; j < arr.length - i; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.err.println(Arrays.toString(arr));
        int k = 2;
        if (k > arr.length) return;
        for (int i = 0; i < arr.length && k>=1 && k<=arr.length; i++){
            k = arr[arr.length - k];
        }
        System.err.println(k);
    }
}
