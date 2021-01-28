package LeetCode;

import java.util.Arrays;

/**
 * @author ：CK
 * @date ：Created in 2020/11/26 10:26
 * @description：
 */
public class No164 {
    //不讲武德
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int temp=0;
        int res=0;
        if(nums.length<2) return 0;
        for(int i=0;i<nums.length-1;i++){
            temp=nums[i+1]-nums[i];
            res=Math.max(res,temp);
        }
        return res;
    }

    //基数排序
    public int maximumGap1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        long exp = 1;
        int[] buf = new int[n];
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / (int) exp) % 10;
                cnt[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buf, 0, nums, 0, n);
            exp *= 10;
        }

        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
}
