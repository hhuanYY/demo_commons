package com.utils.日常api.递归;

/**
 * @author: yuanyinhuan
 * @date: 2021/9/22 15:19
 */
public class RecursiveDemo {

    public int getRecursive(int sum) {
        if (sum == 1) {
            sum = 1;
        } else {
            sum = sum + getRecursive(sum - 1);
        }
        return sum;
    }
}
