/**
 * @Class：TwoSumSolution
 * @Author:520.2.1
 * @BulidDate:2022/09/03
 */
package 哈希表及相应练习;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {
    //哈希法：为什么用Hash？
    //当我们需要查询一个元素是否出现过，或者一个元素是否在集合里的时候，就要第一时间想到哈希法。
    //我们不仅要知道元素有没有遍历过，还有知道这个元素对应的下标——>使用map就非常合适！
    public int[] twoSum(int[]nums,int target){
        int[] res=new int[2];
        if(nums==null || nums.length==0){
            return res;
        }
        //注意Java中map的定义！
        //注意map中key是nums【i】的值，value则是数组索引
        Map<Integer,Integer> map =new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int tmp = target - nums[i];
            if(map.containsKey(tmp)){
                res[1]=i;
                res[0]=map.get(tmp);
            }
            else {
                map.put(nums[i],i);
            }
        }
        return res;
    }

}
