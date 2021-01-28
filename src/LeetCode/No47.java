package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/9/18 10:27
 * @description：
 */
public class No47 {
    private List<List<Integer>> lists;
    public void dfs(List<Integer> list, int[] nums, boolean[] exists, int k){
        if (list.size() == nums.length){
            List<Integer> result = new ArrayList<>(list);
            lists.add(result);
            return;
        }
        for (int j = 0 ;j < nums.length; j++){
            if (!exists[j]){
                if (j>0 && nums[j] == nums[j-1] && !exists[j-1]){
                    continue;
                }
                list.add(nums[j]);
                exists[j] = true;
                dfs(list, nums, exists, k+1);
                list.remove(k);
                exists[j] = false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        lists = new ArrayList<>();
        Arrays.sort(nums);
        dfs(new ArrayList<Integer>(), nums, new boolean[nums.length], 0);
        return lists;
    }
    public static void main(String[] args){
        int[] board = new int[]{2,2,1,1};
        No47 no47 =new No47();
        System.out.println(no47.permuteUnique(board));
    }
}
