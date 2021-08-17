package 每日一练.数组_字符串相关;

import java.util.Arrays;

/**
* @program: dataStructure
* @description: 
* @author: 袁银欢
* @createTime: 2021/03/03 17:43
**/
public class Two_Number_Addition {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.err.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            /**
             * 注意：两个数不相等，target = arr[i] + arr[j];  (i != j) -- 控制内层循环次数即可.
             */
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
