/**
 * @Class：IsHappySoulution
 * @Author:520.2.1
 * @BulidDate:2022/09/02
 */
package 哈希表及相应练习;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IsHappySoulution {
    public static int change(int i){
        int sum=0;
        while(i/10!=0){
            sum+=(i%10)*(i%10);
            i=i/10;
        }
        return sum+i*i;
    }
    public static boolean isHappy(int n) {
        if(n==1){
            return true;
        }
        Set<Integer> set1=new HashSet<>();
        set1.add(n);
        while(true){
            n=change(n);
            if (n==1){
                return true;
            }
            else if(set1.contains(n)){
                return false;
            }
            //教训：忘记加这个了捏，救命
            else{set1.add(n);}
        }
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(isHappy(n));
    }
}
