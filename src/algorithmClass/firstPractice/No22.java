package algorithmClass.firstPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2021/1/5 22:53
 * @description：
 */
public class No22 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int e_num = scan.nextInt();//测试数
        scan.nextLine();
        while(e_num>0){
            int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] gap = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0 ; i < gap.length ; i ++){
                for (int j = gap[i] ; j < array.length ; j ++){
                    int temp = array[j];//记得用temp，不然会被冲掉
                    //必须在外面初始化k，为了在循环外赋值插入的数
                    int k = j - gap[i];
                    for (;k >= 0 && array[k] > temp; k -= gap[i]){
                        array[k + gap[i]] = array[k];
                    }
                    //必须在这层循环结束后赋值，不然可能无法赋值
                    array[k + gap[i]] = temp;
                }
            }
            for (int i = 0 ; i < array.length ; i ++){
                if (i < array.length - 1) {
                    System.out.print(array[i] + " ");
                }
                else {
                    System.out.println(array[i]);
                }
            }
            e_num --;
        }
    }
}
