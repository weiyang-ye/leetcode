package com.jude.java;

import java.util.Arrays;

/**
 * @author jude
 * @create 2022-08-28-19:19
 */
public class RemoveElement1 {
    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
//        int[] arr = {1, 2, 3, 4};
        int var = 1;
        remove(arr, var);
        System.out.println(Arrays.toString(arr));

    }
    public static int remove(int[] nums, int val) {
        int n = nums.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}