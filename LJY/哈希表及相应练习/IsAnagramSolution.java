/**
 * @Class：isAnagramSolution
 * @Author:520.2.1
 * @BulidDate:2022/09/02
 */
package 哈希表及相应练习;

public class IsAnagramSolution {
    public boolean isAnagram(String s, String t) {
        int[] record=new int[26];
        // 注意循环的新形式！！！！！！！！！！！
        for(char c:s.toCharArray()){
            record[c-'a']++;
        }
        for(char c:t.toCharArray()){
            record[c-'a']--;
        }
        for(int i = 0; i<26;i++){
            if(record[i]!=0){
                return  false;
            }
        }
        return true;
    }
}
