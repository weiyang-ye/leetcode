/**
 * @Class：FourSumCountSolution
 * @Author:520.2.1
 * @BulidDate:2022/09/03
 */
package 哈希表及相应练习;

import java.util.HashMap;
import java.util.Map;

/*给定四个包含整数的数组列表 A , B , C , D ,
计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，
且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，
最终结果不会超过 2^31 - 1 。
* */

public class FourSumCountSolution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // key:a+b的结果 value:他们出现的次数
        Map<Integer,Integer> AaddB =new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(AaddB.containsKey(nums1[i]+nums2[j])){
                    AaddB.put(nums1[i]+nums2[j],AaddB.get(nums1[i]+nums2[j])+1);
                }
                else {
                    AaddB.put(nums1[i]+nums2[j],1);
                }
            }
        }
        int count=0;
        for(int i:nums3){
            for(int j:nums4){
                if (AaddB.containsKey(0-(i+j))){
                    count+=AaddB.get(0-(i+j));
                }
            }
        }
        return count;
    }
}
