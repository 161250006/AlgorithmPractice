package algorithmClass.firstPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2021/1/2 12:00
 * @description：
 */
public class No6 {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int e_num = scan.nextInt();//测试数
            while(e_num>0){
                try {
                long number = scan.nextLong();
                //开始
                long i = 1;
                while (number >= i*i){
                    number -= i * i;
                    i++;
                }
                System.out.println(i - 1);
                }
                catch (Exception e){
                    System.out.println(0);
                }
                e_num --;
            }
    }
}
