package algorithmClass.firstPractice;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：CK
 * @date ：Created in 2021/1/4 16:44
 * @description：
 */
public class No20 {
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
                mergeSort(array);
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

    //merge函数
    public static void merge(int[] array , int left ,int mid, int right){
        if(right-left<=0){
            return ;
        }else {
            ArrayList<Integer> temp = new ArrayList<>();
            int i = left;
            int j = mid + 1;
            while (i <= mid && j <= right) {
                if (array[i] <= array[j]) {
                    temp.add(array[i]);
                    i++;
                } else {
                    temp.add(array[j]);
                    j++;
                }
            }
            for (; j <= right; j++) {
                temp.add(array[j]);
            }
            for (; i <= mid; i++) {
                temp.add(array[i]);
            }
            //记得回写回原数组
            for (int k = 0; k < right - left + 1; k++) {
                array[left + k] = temp.get(k);
            }
        }
    }

    //归并
    public static void mergeSort(int[] arr) {
        //i是left到mid的距离
        for (int i = 1; i <= arr.length; i *= 2) {
            //所以后面要乘2，这样计算中心点更方便,当然用left到right的也行
            for (int j = 0; j + i <= arr.length; j += i * 2) {
                //Math.min 的目的是处理 整个待排序数组为奇数的情况
                merge(arr, j, j + i - 1, Math.min(j + 2 * i - 1, arr.length - 1));
            }
        }
    }
}
