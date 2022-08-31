package 数组及相应练习;
/*
 * @Author: error: git config user.name && git config user.email & please set dead value or install git
 * @Date: 2022-08-28 11:24:54
 * @LastEditors: error: git config user.name && git config user.email & please set dead value or install git
 * @LastEditTime: 2022-08-31 12:01:18
 * @FilePath: \Leetcode\DichotomousSearchAndDeleteElement.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
class DichotomousSearchAndDeleteElement {

    static int[]  DeleteTestList = {0, 1, 1, 2, 3, 4, 2, 8, 2};
    static int[] SearchTestList = {0, 1, 2, 3, 4, 8, 9, 10};

    //左闭右闭
    public static int DichotomousSearchA(int[] list,int target) {
        if (target < list[0] || target > list[list.length - 1]){
            return -1;
        }
        int left = 0;
        int right = list.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1); //这里移位运算可以提升程序运算速度
            if (list[mid] == target) {
                return mid;
            }
            else if (list[mid] > target) {
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    } 

    //左闭右开
    public static int DichotomousSearchB(int[] list,int target) {
        if (target < list[0] || target > list[list.length - 1]){
            return -1;
        }
        int left = 0;
        int right = list.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1); //这里移位运算可以提升程序运算速度
            if (list[mid] == target) {
                return mid;
            }
            else if (list[mid] > target) {
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    } 

    public static int DeleteElementA(int[] list, int target){
        int size = list.length;
        for (int i = 0; i < size; i++){
            if(list[i] == target){
                for (int j = i + 1; j < size; j++){
                    list[j - 1] = list[j];
                }
                size--;
                i--;
            }
        }
        return size;
    }

    public static int DeleteElementB(int[] list, int target){
        int slowindex = 0;
        for (int fastindex = 0; fastindex < list.length; fastindex++){
            if(list[fastindex] != target){
                list[slowindex++] = list[fastindex];
            }
        }
        return slowindex;
    }

    public static void main(String[] strs){
        System.out.println(DichotomousSearchA(SearchTestList, 2));
        System.out.println(DichotomousSearchB(SearchTestList, 2));
        System.out.println(DeleteElementA(DeleteTestList,2));
        System.out.println(DeleteElementB(DeleteTestList,2));
    }
}
