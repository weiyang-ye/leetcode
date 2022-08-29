

import java.util.Arrays;

//有序数组的平方
/* 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 */
public class SquaringOfOrderedArrays {
    static int[] nums = {-4, -1, 0, 1, 3};

    // 暴力解法，直接先平方后排序
    // O(n+nlogn)
    public static int[] SortedSquaringA(int[] nums){
        int[] result = new int[nums.length];
        for(int i = 0;i < nums.length; i++){
           result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }
    
    // 双指针法
    // O(n)
    public static int[] SortedSquaringB(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1;
        while(left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                result[index--] = nums[left] * nums[left];
                left++;
            }
            else{
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }

    public static void main(String[] avgs){
        int[] result = new int [nums.length];
        result = SortedSquaringA(nums);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
        result = SortedSquaringB(nums);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i]+"\t");
        }
   }
}
