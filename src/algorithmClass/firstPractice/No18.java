package algorithmClass.firstPractice;

import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2021/1/4 15:42
 * @description：
 */
public class No18 {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            while(scan.hasNextLine()){
                int length = scan.nextInt();
                int[] array = new int[length];
                int[] result = new int[length];
                for(int i=0;i<length;i++){
                    array[i] = scan.nextInt();
                }
                //开始
                int[] x = straightSort(array,length,result);
                for (int i = 0 ; i < length ; i ++){
                    if (result[x[i]] == 0) {
                        result[x[i]] = array[i];
                    }
                    else {
                        result[x[i] + 1] = array[i];
                    }
                }
                for (int i = 0 ; i < length ; i ++){
                    if (i < length - 1) {
                        System.out.print(result[i] + " ");
                    }
                    else {
                        System.out.println(result[i]);
                    }
                }
            }
        }
        catch (Exception e){

        }
    }

    //计数排序
    public static int[] straightSort(int[] arr,int len, int[] result) {
        int[] x = new int[len];
        for (int i = 0 ; i < len;i++) {
            for (int j = 0 ; j < len; j++) {
                if (i != j && arr[j] < arr[i]){
                    x[i] ++;
                }
            }
        }
        return x;
    }
}
