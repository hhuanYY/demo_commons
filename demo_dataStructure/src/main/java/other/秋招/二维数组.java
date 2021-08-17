package other.秋招;

import java.util.ArrayList;

public class 二维数组 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4,5,6},{4,5,6},{},{}};
        System.err.println(arr[3].length);
        ArrayList<Integer> arr1 = new ArrayList<>(5);
        System.err.println(arr1);
        String str = "hhaun";
        char[] c = str.toCharArray();
        for (int i = c.length-1; i>=0; --i){
            System.err.print(c[i]);
        }
        System.err.println("xxx"+0/10);
        int x = Math.min(8,5);
        System.err.println(x);
    }
}
