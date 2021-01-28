package LeetCode;

import java.util.Arrays;

/**
 * @author ：CK
 * @date ：Created in 2021/1/8 18:49
 * @description：
 */
public class No189 {
    //自己写的，是用来额外空间
    public void rotate(int[] nums, int k) {
        int[] temp;
        while (k > nums.length){
            k -= nums.length;
        }
        temp = Arrays.copyOfRange(nums,nums.length - k , nums.length);
        for (int i = nums.length - 1 ; i >= k ; i --){
            nums[i] = nums[i - k];
        }
        for (int i = 0 ; i < k ; i ++){
            nums[i] = temp[i];
        }
    }

    //环形替换
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }


    //数组翻转，第一次全部翻转，然后对两组数字分别翻转即可
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
