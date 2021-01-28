package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/9/6 16:02
 * @description：
 */
public class No4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int total = length1 + length2;
        int k =0;
        if (length1 == 0){
            return (length2 % 2)==1 ? nums2[length2/2] : ((double)(nums2[length2/2-1]+nums2[length2/2]))/2;
        }
        if (length2 == 0){
            return (length1 % 2)==1 ? nums1[length1/2] : ((double)(nums1[length1/2-1]+nums1[length1/2]))/2;
        }
        if (total % 2 == 1){
            k = (total + 1) / 2;
            return getKthElement(nums1, nums2, k);
        }
        else {
            k = (total) / 2;
            return (getKthElement(nums1,nums2,k)+getKthElement(nums1,nums2,k+1))/2;
        }
    }
    public double getKthElement(int[] nums1, int[] nums2, int k) {
        int i1 = 0, i2 = 0;
        int x1 = 0, x2 = 0;
        while (true){
            if(x1 >= nums1.length){
                return nums2[x2 + k - 1];
            }
            if(x2 >= nums2.length){
                return nums1[x1 + k - 1];
            }
            if (k == 1){
                return Math.min(nums1[x1],nums2[x2]);
            }
            i1 = Math.min(x1 + k/2 -1,nums1.length-1);
            i2 = Math.min(x2 + k/2 -1,nums2.length-1);
            if (nums1[i1] <= nums2[i2]){
                k = k - (i1 + 1 - x1);
                x1 = i1 + 1;
            }
            if (nums2[i2] < nums1[i1]){
                k = k - (i2 + 1 - x2);
                x2 = i2 + 1;
            }
        }
    }
    public static void main(String[] args){
        No4 no4 = new No4();
        System.out.println(no4.findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));

    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        // 分割线左边的所有元素需要满足的个数 m + (n - m + 1) / 2;
        int totalLeft = (m + n + 1) / 2;

        // 在 nums1 的区间 [0, m] 里查找恰当的分割线，
        // 使得 nums1[i - 1] <= nums2[j] && nums2[j - 1] <= nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮搜索的区间 [left, i - 1]
                right = i - 1;
            } else {
                // 下一轮搜索的区间 [i, right]
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if (((m + n) % 2) == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        } else {
            return (double) ((Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))) / 2;
        }
    }
}
