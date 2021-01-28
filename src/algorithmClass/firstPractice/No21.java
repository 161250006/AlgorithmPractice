package algorithmClass.firstPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2020/12/28 15:37
 * @description：
 */
public class No21 {

    public static int mergeSort(int[] array,int left,int right){
        if(right-left<=0){
            return 0;
        }else{
            int mid=(left+right)/2;
            int count=mergeSort(array,left,mid)+mergeSort(array,mid+1,right);
            ArrayList<Integer> temp = new ArrayList<>();
            int i=left;
            int j=mid+1;
            while(i<=mid && j<=right){
                if(array[i]<=array[j]){
                    temp.add(array[i]);
                    i++;
                }else{
                    //右边的比左边的小，说明倒序，把左边这个数以及其所有左边的都加上
                    count += mid-i+1;
                    temp.add(array[j]);
                    j++;
                }
            }
            for(;j<=right;j++){
                temp.add(array[j]);
            }
            for(;i<=mid;i++){
                temp.add(array[i]);
            }
            //记得回写回原数组
            for(int k=0;k<right-left+1;k++){
                array[left+k]=temp.get(k);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int e_num = scan.nextInt();//测试数
        while(e_num>0){
            int length = scan.nextInt();
            int[] array = new int[length];
            for(int i=0;i<length;i++){
                array[i] = scan.nextInt();
            }
            int result = mergeSort(array,0,length-1);
            System.out.println(result);
            e_num --;
        }
    }
}
