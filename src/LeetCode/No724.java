package LeetCode;

import java.util.Arrays;

/**
 * @author ：CK
 * @date ：Created in 2021/1/28 11:03
 * @description：
 */
public class No724 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0){
            return -1;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum - nums[0] == 0){
            return 0;
        }
        int s = 0;
        for (int i = 1 ; i < nums.length ; i ++){
            //这一步调到后面，然后从0开始，可以不用前面的判断
            s += nums[i - 1];
            //用乘法更好些，不用判断余数
            if ((sum - nums[i]) % 2 == 0 && (sum - nums[i]) / 2 == s){
                return i;
            }
        }
        return -1;
    }
}
