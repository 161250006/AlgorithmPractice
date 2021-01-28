package algorithmClass.firstPractice;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2021/1/3 11:29
 * @description：
 */
public class No8 {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int e_num = scan.nextInt();//测试数
            while(e_num>0){
                long a = scan.nextLong();
                long b = scan.nextLong();
                long c = scan.nextLong();
                //开始
                int ans = 1;
                //快速幂算法
                while(b > 0){
                    if((b & 1)!= 0){
                        ans *= a;
                    }
                    //余数分解公式
                    a = ((a % c) * (a % c)) % c;
                    b >>= 1;
                }
                System.out.println(ans%c);
                e_num --;
            }
        }
        catch (Exception e){

        }
    }
}
