package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/11/28 11:01
 * @description：
 */
public class No493 {
    //超时
    public int reversePairs(int[] nums) {
        int sum = 0;
        for (int i = 0 ; i < nums.length ; i ++){
            for (int j = i+1 ; j < nums.length ; j ++){
                if (nums[j] < 0 && nums[i] >= nums[j]){
                    sum++;
                    continue;
                }
                if (2 * nums[j] < nums[j] && nums[j] > 0){
                    continue;
                }
                if (nums[i] > nums[j] * 2){
                    sum++;
                }
            }
        }
        return sum;
    }
    public int reversePairs1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    public int reversePairsRecursive(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = reversePairsRecursive(nums, left, mid);
            int n2 = reversePairsRecursive(nums, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int j = mid + 1;
            while (i <= mid) {
                while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                    j++;
                }
                ret += j - mid - 1;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = nums[p2++];
                } else if (p2 > right) {
                    sorted[p++] = nums[p1++];
                } else {
                    if (nums[p1] < nums[p2]) {
                        sorted[p++] = nums[p1++];
                    } else {
                        sorted[p++] = nums[p2++];
                    }
                }
            }
            for (int k = 0; k < sorted.length; k++) {
                nums[left + k] = sorted[k];
            }
            return ret;
        }
    }
}
