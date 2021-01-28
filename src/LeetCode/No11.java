package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/12/25 21:40
 * @description：
 */
public class No11 {
    //题解的双指针解法，很经典，证明看题解，建议直接记住（暴力法就不写了）
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }
}
