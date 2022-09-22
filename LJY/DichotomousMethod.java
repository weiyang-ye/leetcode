/**
 * @Class：DichotomousMethod
 * @Author:520.2.1
 * @BulidDate:2022/09/22
 */

public class DichotomousMethod {
    public static int Dichtomous1(double[] arr,double target){
        int left=0;
        int right=arr.length;
        while (left<right){
            int mid = left +(right-left)>>1;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>target){
                right=mid;
            }
            if(arr[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }
    //寻找大于等于target的数
    public static int Dichotomous2(double[] arr,double target){
        int left=0;
        int right=arr.length-1;
        int temp=-1;
        while(left<=right){
            int mid = left+(right-left)>>1;
            if(arr[mid]==target){
                temp=mid;
                right=mid-1;
            }
            if(arr[mid]>target){
                right=mid-1;
            }
            if(arr[mid]<target){
                left=mid+1;
            }
        }
        return temp;
    }
    //寻找无序数组中的一个局部最小值对应的数组下标
    public static int Dichotomous3(double[] arr,double targrt){
        int left=0;
        int right= arr.length;
        if(arr[0]<arr[1]){
            return 0;
        }
        if(arr[right-1]<arr[right-2]){
            return right-1;
        }
        while (left<right){
            int mid=left+(right-left)>>1;
            if(arr[mid]<arr[mid+1]&&arr[mid]<arr[mid-1]){
                return mid;
            }
            if(arr[mid]<arr[mid+1]&&arr[mid]>arr[mid-1]){
                right=mid;
            }
            if(arr[mid]>arr[mid+1]&&arr[mid]<arr[mid-1]){
                left=mid+1;
            }
        }
        return -1;
    }
}
