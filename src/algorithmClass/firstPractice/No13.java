package algorithmClass.firstPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：CK
 * @date ：Created in 2021/1/2 23:12
 * @description：
 */
public class No13 {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int e_num = scan.nextInt();//测试数
            while(e_num>0){
                int length = scan.nextInt();
                int total = scan.nextInt();
                int[] array = new int[length];
                for(int i=0;i<length;i++){
                    array[i] = scan.nextInt();
                }
                List<List<Integer>> result = fourSum(array,total);
                for (List<Integer> a : result){
                    for(Integer i : a){
                        System.out.print(i + " ");
                    }
                    System.out.print("$");
                }
                System.out.print("\n");
                e_num --;
            }
        }
            catch (Exception e){

        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            //三个if都是剪枝过程（暴力一点可以没有）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                //同上
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                //同三数之和
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //剪枝
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        //剪枝
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }
}
