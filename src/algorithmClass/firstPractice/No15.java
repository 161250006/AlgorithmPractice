package algorithmClass.firstPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2021/1/3 22:52
 * @description：
 */
public class No15 {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int e_num = scan.nextInt();//测试数
            while(e_num>0){
                int length = scan.nextInt();
                int[] array = new int[length];
                int[] sorted = new int[length];
                for(int i=0;i<length;i++){
                    array[i] = scan.nextInt();
                    sorted[i] = array[i];
                }
                //开始
                Arrays.sort(sorted);
                int sum = 0;
                for (int i = 0 ; i < length ; i ++){
                    if (sorted[i] != array[i]){
                        int index = 0;
                        for (int j = 0 ; j < length ; j ++){
                            if (array[j] == sorted[i]){
                                index = j;
                                break;
                            }
                        }
                        array[index] = array[i];
                        array[i] = sorted[i];
                        sum++;
                    }
                }
                System.out.println(sum);
                e_num --;
            }
        }
        catch (Exception e){

        }
    }
}
