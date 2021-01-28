package algorithmClass.firstPractice;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：CK
 * @date ：Created in 2021/1/4 16:24
 * @description：
 */
public class No19 {
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
                quickSort2(array);
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

    //快速排序，递归
    public static void quickSort(int[] arr,int low,int high) {
        int p,i,j,temp;

        //只有一个数的时候直接返回
        if(low >= high) {
            return;
        }
        //p就是基准数,这里就是每个数组的第一个
        p = arr[low];
        i = low;
        j = high;
        //不断寻找不符合条件的值，然后交换，注意是先j后i，也就是先又后左的顺序
        while(i < j) {
            //右边当发现小于p的值时停止循环
            while(arr[j] >= p && i < j) {
                j--;
            }

            //这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）

            //左边当发现大于p的值时停止循环
            while(arr[i] <= p && i < j) {
                i++;
            }

            //交换i，j位置的两个数,加一个i<j的判断可以避免自己与自己交换
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            //这里不加i++和j--是因为这样可能会跳出循环，从而无法判断这个点是否小于p，从而让下面的交换失效
        }
        //对于最后在i位置上的数字和第一个数字交换位置
        arr[low] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走，因为相交的点让只有在第一个循环停住才能相交)
        arr[i] = p;
        quickSort(arr,low,j-1);  //对左边快排
        quickSort(arr,j+1,high); //对右边快排

    }

    //非递归
    public static void quickSort2(int[] array) {
        if (array == null || array.length == 1) return;
        //存放开始与结束索引
        Stack<Integer> s = new Stack<Integer>();
        //压栈
        s.push(0);
        s.push(array.length - 1);
        //利用循环里实现
        while (!s.empty()) {
            int right = s.pop();
            int left = s.pop();
            //如果最大索引小于等于左边索引，说明结束了
            if (right <= left) continue;

            int i = partition(array, left, right);
            //左边
            if (left < i - 1) {
                s.push(left);
                s.push(i - 1);
            }
            //右边
            if (i + 1 < right) {
                s.push(i+1);
                s.push(right);
            }
        }
    }
    //找到轴心，进行交换，我直接用的上面的方法，我觉得这个更好理解
    public static int partition (int[] arr, int low, int high)
    {
        int p,i,j,temp;

        //p就是基准数,这里就是每个数组的第一个
        p = arr[low];
        i = low;
        j = high;
        //不断寻找不符合条件的值，然后交换，注意是先j后i，也就是先又后左的顺序
        while(i < j) {
            //右边当发现小于p的值时停止循环
            while(arr[j] >= p && i < j) {
                j--;
            }

            //这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）

            //左边当发现大于p的值时停止循环
            while(arr[i] <= p && i < j) {
                i++;
            }

            //交换i，j位置的两个数,加一个i<j的判断可以避免自己与自己交换
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            //这里不加i++和j--是因为这样可能会跳出循环，从而无法判断这个点是否小于p，从而让下面的交换失效
        }
        //对于最后在i位置上的数字和第一个数字交换位置
        arr[low] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走，因为相交的点让只有在第一个循环停住才能相交)
        arr[i] = p;
        //返回轴心
        return i;
    }

    //这是另一种，我不知道哪一种更好
    public int partition2 (int[] data, int first, int end)
    {
        int temp;
        int i=first,j=end;
        if(first<end)
        {
            temp=data[i];
            //当i=j的时候，则说明扫描完成了
            while(i<j)
            {
                //从右边向左边扫描找到一个小于temp的元素
                while(j>i&&data[j]>temp)j--;
                if(i<j)
                {
                    //将该元素赋值给temp
                    data[i]=data[j];
                    //赋值后就应该将i+1指向下一个序号
                    i++;
                }

                //然后从左边向右边开始扫描，找到一个大于temp的元素
                while(i<j&&temp>data[i])i++;
                if(i<j)
                {
                    //将该元素赋值给temp
                    data[j]=data[i];
                    //赋值后就应该将j-1指向前一个序号
                    j--;
                }
            }
            //将轴数据放在i位置中
            data[i]=temp;
        }
        return i;
    }
}
