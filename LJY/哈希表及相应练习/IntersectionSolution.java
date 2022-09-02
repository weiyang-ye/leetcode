/**
 * @Class：IntersectionSolution
 * @Author:520.2.1
 * @BulidDate:2022/09/02
 */
package 哈希表及相应练习;

import java.util.HashSet;
import java.util.Set;

public class IntersectionSolution {
    // 应用数组做哈希表
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] hashmap = new int[1005];
        int[] res = new int[1005];
        int count=0;
        for (int i = 0; i<nums1.length; i++){
            hashmap[nums1[i]]++;
        }
        for (int i = 0; i<nums2.length; i++){
            // 教训：这里的判断条件要注意，如果第二个集有两个重复的情况，count不要加多了！！！
            if(hashmap[nums2[i]]!=0 && res[nums2[i]]!=1){
                res[nums2[i]]=1;
                count++;
            }
        }
        int[] rest = new int[count];
        count=0;
        for(int i =0 ; i<res.length;i++){
            if(res[i]==1){
                rest[count++]=i;
            }
        }
        return rest;
    }
    //Java使用unordermap
    public static int[] intersection2(int[]nums1,int[]nums2){
        Set<Integer> set1=new HashSet<>();
        Set<Integer> resSet=new HashSet<>();
        for(int i:nums1){
            set1.add(i);
        }
        for(int i:nums2){
            if(set1.contains(i)){
                resSet.add(i);
            }
        }
        return resSet.stream().mapToInt(x ->x).toArray();

    }
    public static void main(String[] args) {
        int[] nums1={1,2,3,4,5,6,2};
        int[] nums2={2,6,2};
        int[] res=intersection(nums1,nums2);
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
