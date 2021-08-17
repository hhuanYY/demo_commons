package 每日一练.数组_字符串相关;

/**
* @program: dataStructure
* @description: 去重排序数组 并返回数组长度 [返回结果有点问题...]
* @author: 袁银欢
* @createTime: 2021/03/05 15:07
**/
public class Duplicate_Of_Sort_Array {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1};
        System.err.println(dup_sort_array(arr));
    }

    private static int dup_sort_array(int[] arr) {
        Integer p = 0;
        Integer q = 1;
        while (q < arr.length) {
            /**
             *  1. 定义p、q两个指针,初始化为0、1
             *  2. 当 arr[p] = arr[q]时, q++向后移动一位
             *  3. 当 arr[p] != arr[q], 把arr[q]的值赋值给 arr[p+1]处, 并且p++ q++同时向后移动一位
             */
            if (arr[p] != arr[q]) {
                arr[p + 1] = arr[q];
                p++;
            }
            q++;
        }

        return p+1;
    }
}
