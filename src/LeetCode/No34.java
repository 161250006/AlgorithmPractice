package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/12/1 10:30
 * @description：
 */
public class No34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int i = 0 , j = nums.length - 1;
        if (nums.length == 0 || nums[0] > target || nums[nums.length-1] < target){
            return new int[]{-1,-1};
        }
        while (i <= j){
            int mid = (i + j)/2;
            if (nums[mid] < target){
                i = mid+1;
            }
            else if (nums[mid] == target){
                int xi = i , xj = mid, yi = mid , yj = j;
                while (xi <= xj){
                    int midx = (xi + xj)/2;
                    if (nums[midx] < target){
                        xi = midx+1;
                    }
                    else if (nums[midx] > target){
                        xj = midx-1;
                    }
                    else {
                        if ((midx > 0 && nums[midx - 1] < target) || (midx == 0)){
                            result[0] = midx;
                            break;
                        }
                        xj = midx - 1;
                    }
                }
                while (yi <= yj){
                    int midy = (yi + yj)/2;
                    if (nums[midy] < target){
                        yi = midy+1;
                    }
                    else if (nums[midy] > target){
                        yj = midy-1;
                    }
                    else {
                        if ((midy < nums.length-1 && nums[midy + 1] > target) || (midy == nums.length-1)){
                            result[1] = midy;
                            break;
                        }
                        yi = midy + 1;
                    }
                }
                return result;
            }
            else if (nums[mid] > target){
                j = mid-1;
            }
        }
        return new int[]{-1,-1};
    }

    //直接二分搜索，查找第一个大于等于target的树，和第一个大于target的数，并且代码复用
    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
