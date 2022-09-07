/**
 * @Class：ThreeSum
 * @Author:520.2.1
 * @BulidDate:2022/09/05
 */
package 哈希表及相应练习;

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
//
//你返回所有和为 0 且不重复的三元组。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/3sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.*;

public class ThreeSum {
    // 哈希表解法
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        // 从大到小重新排列sums
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0&&nums[i]==nums[i-1]){
                //三元组中的元素a去重
                continue;
            }
            Set<Integer> set1=new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                if(j>i+2
                        && nums[j]==nums[j-1]
                        && nums[j]==nums[j-2]){
                    continue;
                }
                int c = 0-(nums[i]+nums[j]);
                if(set1.contains(c)){
                    result.add(Arrays.asList(nums[i],nums[j],c));
                    set1.remove(c);
                }
                else {
                    set1.add(nums[j]);
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i <nums.length;i++){
            if (nums[i]>0){
                return result;
            }

            if(i>0&&nums[i]==nums[i-1]){
                //我们要做的是 不能有重复的三元组，但三元组内的元素是可以重复的！
                continue;
            }
            int left = i + 1;
            int right = nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }
                else if (nums[i]+nums[left]+nums[right]<0){
                    left++;
                }
                else {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right &&nums[right]==nums[right-1]) {
                        right--;
                    }
                    while (left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
