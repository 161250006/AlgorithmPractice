package algorithmClass.firstPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2021/1/4 11:26
 * @description：
 */
public class No16 {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int e_num = scan.nextInt();//测试数
            while(e_num>0){
                int length = scan.nextInt();
                int[] array = new int[length];
                for(int i=0;i<length;i++){
                    array[i] = scan.nextInt();
                }
                //开始
                straightSort(array,length);
                for (int i = 0 ; i < length ; i ++){
                    if (i < length - 1) {
                        System.out.print(array[i] + " ");
                    }
                    else {
                        System.out.println(array[i]);
                    }
                }
                e_num --;
            }
        }
        catch (Exception e){

        }
    }

    //插入排序，
    public static void straightSort(int[] arr,int len)
    {
        int tmp;
        int i;
        int j;
        for (i = 1;i < len;i++)
        {
            tmp = arr[i];//记得用temp，不然会被冲掉
            //必须在外面初始化k，为了在循环外赋值插入的数
            for (j = i - 1;j >= 0 && arr[j] > tmp;j--)
            {
                arr[j + 1] = arr[j];
            }
            //必须在这层循环结束后赋值，不然可能无法赋值（到0了都没有比他小的）
            arr[j + 1] = tmp;
        }
    }
}
