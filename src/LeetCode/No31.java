package LeetCode;

import java.util.Arrays;

/**
 * @author ：CK
 * @date ：Created in 2020/11/10 9:04
 * @description：
 */
public class No31 {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2){
            return;
        }
        int num = nums.length - 2;
        while (num >= 0){
            if (nums[num] < nums[num + 1]){
                break;
            }
            num --;
        }
        if (num == -1){
            Arrays.sort(nums);
            return;
        }
        int replace = num + 1;
        for (int i = num + 1 ; i < nums.length ; i ++){
            if (nums[num] < nums[i] && nums[replace] > nums[i]){
                replace = i;
            }
        }
        int k = nums[num];
        nums[num] = nums[replace];
        nums[replace] = k;
        Arrays.sort(nums , num + 1 , nums.length);
    }
}
