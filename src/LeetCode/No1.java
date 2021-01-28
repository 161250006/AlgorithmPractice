package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/9/6 16:02
 * @description：
 */
public class No1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if((nums[i]+nums[j])==target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }
}
