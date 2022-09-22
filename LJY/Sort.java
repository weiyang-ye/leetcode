import java.util.Arrays;

/**
 * @Class：Sort
 * @Author:520.2.1
 * @BulidDate:2022/09/22
 */

public class Sort {
    // 选择排序
    public static void SelectionSort(double[] input){
        double temp=0;
        for(int i=0;i<input.length;i++){
            for (int j=i+1;j<input.length;j++){
                if(input[i]>input[j]){
                    temp=input[i];
                    input[i]=input[j];
                    input[j]=temp;
                }
            }
        }
    }
    //冒泡排序
    public static void BubbleSort(double[] in){
        double tmp=0;
        int flag=0;
        do{
            flag=0;
            for(int i=0;i<in.length-1;i++){
                if(in[i]>in[i+1]){
                    tmp=in[i];
                    in[i]=in[i+1];
                    in[i+1]=tmp;
                    flag=1;
                }
            }

        }while (flag==1);
    }
    //插入排序（打牌整理牌的过程）
    public static void  InsertSort(double[] in){
        double tmp=0;
        for(int i =0;i<in.length;i++){
            for(int j=i-1;j>=0&&in[j]>in[j+1];j--){
                tmp=in[j+1];
                in[j+1]=in[j];
                in[j]=tmp;
            }
        }
    }
    //对数器
    public static void compare(double[] in){
        Arrays.sort(in);
    }

    public static void main(String[] args) {
        int maxsize=1000;
        double[] test1=new double[maxsize];
        double[] test2=new double[maxsize];
        double[] test3=new double[maxsize];
        double[] test4=new double[maxsize];
        int trial=10000;
        for(int j=0;j<trial;j++){
            for(int i=0;i<maxsize;i++){
                test1[i]=(int)(Math.random()*100)-(Math.random()*10);
            }
            for(int i=0;i<maxsize; i++){
                test2[i]=test1[i];
                test3[i]=test1[i];
                test4[i]=test1[i];
                //System.out.print("\t"+test1[i]);
            }
            System.out.println();

            InsertSort(test1);
            for(int i=0;i<maxsize; i++){
                System.out.print("\t"+test1[i]);
            }
            System.out.println();

            SelectionSort(test2);
            for(int i=0;i<maxsize; i++){
                System.out.print("\t"+test2[i]);
            }
            System.out.println();

            BubbleSort(test3);
            for(int i=0;i<maxsize; i++){
                System.out.print("\t"+test3[i]);
            }
            System.out.println();

            compare(test4);
            for(int i=0;i<maxsize; i++){
                System.out.print("\t"+test4[i]);
            }
            System.out.println();
            for(int i=0;i<maxsize; i++){
                if(test1[i]!=test4[i]&&test2[i]!=test4[i]&&test3[i]!=test4[i]){
                    System.out.println("排序出错误啦");
                    break;
                }
            }


        }
        //System.out.println("代码写对啦！");

    }
}
