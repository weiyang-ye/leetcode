package com.jude.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jude
 * @create 2022-08-31-21:04
 */
public class SumFourNum {
    public static void main(String[] args) {

        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        fourSum(nums,target);
        System.out.println(fourSum(nums,target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4) {
            return lists;
        }
        for (int i = 0; i < nums.length; i++) {
            //一级剪枝(因为target有可能为负数，不能直接和三数之和一样判断nums[i]>0就break)
            if (nums[i] > target && nums[i] > 0) {
                break;
            }
            //一级去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                //二级剪枝
                if (nums[i] + nums[j] > target && nums[j] > 0) {
                    break;
                }
                //二级去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //左指针去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        //右指针去重
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        //指针移动
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }

            }
        }
        return lists;
    }
}
