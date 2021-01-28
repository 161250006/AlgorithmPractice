package algorithmClass.firstPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2021/1/4 15:24
 * @description：
 */
public class No17 {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            while(scan.hasNextLine()){
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
            }
        }
        catch (Exception e){

        }
    }

    //冒泡排序
    public static void straightSort(int[] arr,int len) {
        for (int i = 0 ; i < len;i++) {
            for (int j = 0 ; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    int k = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = k;
                }
            }
        }
    }
}
