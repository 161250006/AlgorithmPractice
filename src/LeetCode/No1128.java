package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2021/1/26 10:29
 * @description：
 */
public class No1128 {
    //很巧妙，将二元组转化为数字，然后在记录次数，每次出现重复元素就加上之前出现的次数，不用使用排列组合，避免了两次循环或者哈希表的使用。
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ret = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
