package 每日一练.排序算法;

import java.util.Arrays;

/**
* @program: dataStructure
* @description:
 *  1. 使用冒泡排序,N个数组，需要N-1趟排序（使用双循环：外层控制循环趟数、内存控制每一趟的循环次数）
 *      1. 外层从1开始,N个长度的数组,需要N-1趟
 *      2. 内层遍历次数为数组长度 - i,因为内层的遍历次数随着趟数变化！
 *  2. 冒泡有点：
 *      1. 每完成一趟，就会少比较一次，每一趟都会找出一个较大值
 *      2. 时间复杂度：平均复杂度为 O(n^2)
* @author: 袁银欢
* @createTime: 2021/03/03 16:54
**/
public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 3, 8, 7};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i; j++) {
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.err.println(Arrays.toString(arr));
    }
}
