package com.utils.日常api.递归;

/**
 * @author: yuanyinhuan
 * @date: 2021/9/22 15:22
 */
public class MainRecursive {
    public static void main(String[] args) {
        RecursiveDemo recursiveDemo = new RecursiveDemo();
        int recursive = recursiveDemo.getRecursive(100);
        System.err.println(recursive);
    }
}
