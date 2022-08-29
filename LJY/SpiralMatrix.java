/*
 * @Author: error: git config user.name && git config user.email & please set dead value or install git
 * @Date: 2022-08-29 19:42:54
 * @LastEditors: error: git config user.name && git config user.email & please set dead value or install git
 * @LastEditTime: 2022-08-29 20:12:18
 * @FilePath: \Leetcode\SpiralMatrix.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
// 螺旋矩阵
// 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
public class SpiralMatrix {
   static int n = 10;
   public static int[][] GetMatrix(int n){
    int[][] res = new int[n][n];
    int count = 1;
    int i = 0;
    int j = 0;
    int loop = 0;//循环次数
    int offset = 0;
    while(loop++ < n / 2){//注意这里不可以是小于等于！！！
        for(j = offset;  j < n - loop; j++){
            res[offset][j] = count++;//注意这里的offset！
        }
        for(i = offset; i < n - loop; i++){
            res[i][j] = count++;
        }
        for(;j >= loop; j--){
            res[i][j] = count++;
        }
        for(;i >= loop; i--){
            res[i][j] = count++;
        }
        offset++;
    }
    if (n % 2 == 1)
    {
        res[offset][offset] = count;
    }
    return res;
   }

   public static void main(String[] avgs){
    int[][] res = GetMatrix(n);
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            System.out.print(res[i][j]+"\t");
        }
        System.out.print("\n");
    }
   }
}
