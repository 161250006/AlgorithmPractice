package LeetCode;

import java.util.Arrays;

/**
 * @author ：CK
 * @date ：Created in 2021/1/21 13:30
 * @description：
 */
public class No16 {
    //有很多优化空间，比如遇到重复的值就跳过，相等就直接返回等
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0 ; i < nums.length ; i ++){
            //注意这个是i+1，也就是i访问过的就不用再访问了
            int left = i + 1 , right = nums.length - 1;
            while (left < right){
                int x = nums[i] + nums[left] + nums[right];
                result = Math.abs(x - target) <= Math.abs(result - target) ? x : result;
                if (x > target){
                    right --;
                }
                else {
                    left ++;
                }
            }
        }
        return result;
    }
}
