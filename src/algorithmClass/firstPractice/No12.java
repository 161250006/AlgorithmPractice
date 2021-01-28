package algorithmClass.firstPractice;

import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2021/1/3 21:39
 * @description：
 */
public class No12 {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int e_num = scan.nextInt();//测试数
            while(e_num>0){
                int length = scan.nextInt();
                int[][] array = new int[length][2];
                int[] frequency = new int[100001];
                for(int i=0;i<length;i++){
                    array[i][0] = scan.nextInt();
                }
                for(int i=0;i<length;i++){
                    array[i][1] = scan.nextInt();
                }
                //开始
                int max = array[0][0];
                for (int i = 0 ; i < array.length ; i ++){
                    for (int j = array[i][0] ; j <= array[i][1] ; j ++){
                        frequency[j] ++;
                        if (frequency[j] > frequency[max]){
                            max = j;
                        }
                    }
                }
                System.out.println(max + " " + frequency[max]);
            }
        }
        catch (Exception e){

        }
    }
}
