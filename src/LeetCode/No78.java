package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/9/20 11:01
 * @description：
 */
public class No78 {
    private List<List<Integer>> lists;
    public List<List<Integer>> subsets(int[] nums) {
        lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(list, 0, nums);
        return lists;
    }
    public void dfs(List<Integer> list, int k, int[] nums){
        lists.add(new ArrayList<>(list));
        for (int i = k ; i < nums.length ; i ++){
            list.add(nums[i]);
            dfs(list,i+1,nums);
            list.remove((Integer) nums[i]);
        }
    }
}
