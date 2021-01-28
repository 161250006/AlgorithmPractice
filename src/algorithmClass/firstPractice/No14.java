package algorithmClass.firstPractice;

import java.util.List;
import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2021/1/3 22:28
 * @description：
 */
public class No14 {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int e_num = scan.nextInt();//测试数
            while(e_num>0){
                int length = scan.nextInt();
                int[][] array = new int[length][length];
                int h = 0;
                int k = 0;
                for(int i=0;i<length * length;i++){
                    if (k >= length){
                        k = 0;
                        h ++;
                    }
                    array[h][k] = scan.nextInt();
                    k ++;
                }

                //开始
                int[] point = new int[length];
                int num = 0;
                int pre = Integer.MIN_VALUE;
                while (num < length * length){
                    int now = Integer.MAX_VALUE;
                    int x = 0;
                    for (int i = 0 ; i < length ; i ++){
                        if (point[i]<length && array[i][point[i]] >= pre && array[i][point[i]] < now){
                            x = i;
                            now = array[i][point[i]];
                        }
                    }
                    if (num == length * length - 1){
                        System.out.println(now);
                    }
                    else {
                        System.out.print(now + " ");
                    }
                    point[x]++;
                    pre = now;
                    num ++;
                }
                e_num --;
            }
        }
        catch (Exception e){

        }
    }
}
