package algorithmClass.firstPractice;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2021/1/3 11:12
 * @description：
 */
public class No7 {
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
                PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
                int k = 2;//层数
                for (int i = 0 ; i < length ; i ++){
                    if (i < k -1){
                        if (!priorityQueue.contains(array[i])) {
                            priorityQueue.offer(array[i]);
                        }
                    }
                    else {
                        while (!priorityQueue.isEmpty()){
                            if (priorityQueue.size() > 1) {
                                System.out.print(priorityQueue.poll()+" ");
                            }
                            else {
                                System.out.println(priorityQueue.poll());
                            }
                        }
                        priorityQueue.offer(array[i]);
                        k = 2*k;
                    }
                }
                //收尾
                while (!priorityQueue.isEmpty()){
                    if (priorityQueue.size() > 1) {
                        System.out.print(priorityQueue.poll()+" ");
                    }
                    else {
                        System.out.println(priorityQueue.poll());
                    }
                }
                e_num --;
            }
        }
        catch (Exception e){

        }
    }
}
