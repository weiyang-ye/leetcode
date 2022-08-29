package com.jude.java;

/**
 * @author jude
 * @create 2022-08-29-10:03
 */
public class CreateMatrix {
    public static void main(String[] args) {
        int num = 7;
        int[][] createdArr = new int[num][num];
        createdArr = generateMatrix(num);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(createdArr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {

        int[][] arr = new int[n][n];
        int temp = 1;
        int row = 0;
        int col = 0;
        int loop = 1;
        while (loop <= n / 2) {
            //上侧从左往右
            for (; col < n - loop; col++, temp++) {
                arr[row][col] = temp;
            }
            //右侧从上往下
            for (; row < n - loop; row++, temp++) {
                arr[row][col] = temp;
            }
            //下侧从右往左
            for (; col >= loop; col--, temp++) {
                arr[row][col] = temp;
            }
            //左侧从下往上
            for (; row >= loop; row--, temp++) {
                arr[row][col] = temp;
            }
            row++;//因为下侧和左侧处理后，还会进行col--和row--，如果不加一的话会回到起点位置重新开始
            col++;
            loop++;
        }
        //如果是奇数，需要多一轮遍历，该点为数组中心位置的点
        if (n % 2 == 1){
            arr[row][col] = temp;
        }
            return arr;
    }
}
