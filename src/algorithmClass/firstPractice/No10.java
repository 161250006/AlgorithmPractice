package algorithmClass.firstPractice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2021/1/1 21:50
 * @description：
 */
public class No10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int e_num = scan.nextInt();//测试数
        while(e_num>0){
            int woodNum = scan.nextInt();
            int[] array = new int[woodNum];
            for(int i=0;i<woodNum;i++){
                array[i] = scan.nextInt();
            }
            int paintNum = scan.nextInt();
            //开始
            int min_cap = Arrays.stream(array).max().getAsInt();
            int max_cap = Arrays.stream(array).sum();
            if (array.length < paintNum){
                System.out.println("-1");
            }
            else {
                search(min_cap, max_cap, array, paintNum);
            }

            e_num --;
        }
    }

    // 就按照顺序遍历数组累和,如果超过桶容量证明装不下了,桶数量+1,重新换一个新桶
    public static int get_required_painters(int[] arr, int cap) {
        int sum = 0;
        int numPainters = 1;
        for (int x : arr) {
            sum += x;
            if (sum > cap) {
                numPainters += 1;
                sum = x;
            }
        }
        return numPainters;
    }


    // 二分查找
    // 对桶容量进行二分查找,获取当前桶容量对应的桶的个数,根据桶的个数决定查找方向  {key:桶容量,value:桶的个数}
    public static void search(int i, int j, int[] arr, int k) {
        if (i == j) {
            System.out.println(i);
            return;
        }
        int mid = (i + j) / 2;
        int p_num = get_required_painters(arr, mid);  //以mid为容量的桶, 需要多少个才能把数全装完
        if (p_num <= k) {  //如果当前的桶的个数比要找的桶的数量小, 说明当前桶数量过少, 容量过大, 因此就向左搜索,
            //等于也要搜索, 因为在桶数量保持不变时, 当前容量未必是最小容量
            search(i, mid, arr, k);
        }
        else {
            search(mid + 1, j, arr, k);
        }
    }
}
