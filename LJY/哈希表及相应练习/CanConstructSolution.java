/**
 * @Class：CanConstructSolution
 * @Author:520.2.1
 * @BulidDate:2022/09/03
 */
package 哈希表及相应练习;

public class CanConstructSolution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] res = new int[26];
        for(char s :ransomNote.toCharArray()){
            res[s-'a']++;
        }
        for(char s : magazine.toCharArray()){
            res[s-'a']--;
        }
        for(int i :res){
            if(i>0){
                return false;
            }
        }
        return true;
    }
}
