package 数组及相应练习;
/*
 * @Author: error: git config user.name && git config user.email & please set dead value or install git
 * @Date: 2022-08-29 18:50:12
 * @LastEditors: error: git config user.name && git config user.email & please set dead value or install git
 * @LastEditTime: 2022-08-31 12:01:30
 * @FilePath: \Leetcode\TheMinSubArray.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
//长度最小的子数组
/* 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。 */
import java.lang.Math;
public class TheMinSubArray{
    static int s = 7;
    static int[] n = {2, 3, 1, 4, 3};

    public static int getMinSubArray(int s, int[] n){
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int right = 0; right < n.length; right++){
            sum = n[right] + sum;
            while(sum>=s){
                res = Math.min(res, right-left + 1);
                sum = sum - n[left++];//滑动窗口的精髓所在！！！！
            }
        }
        return res == Integer.MAX_VALUE? 0: res;
    }
    public static void main(String[] avgs){
        System.out.println(getMinSubArray(s, n));
    }
}