package com.jude.java;

/**
 * @author jude
 * @create 2022-08-28-20:10
 */
public class SubArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        int tar = 7;
        System.out.println(minSubArrayLen(tar, arr));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                len = Math.min(len, right - left + 1);
                sum -= nums[left];
                left++;

            }
        }
        return len < Integer.MAX_VALUE ? len : 0;
    }
}
