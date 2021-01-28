package LeetCode;

import java.util.*;

/**
 * @author ：CK
 * @date ：Created in 2020/12/31 11:00
 * @description：
 */
public class No435 {
    //这题和气球那一题相似，记住这个算法，452
    //自己写的，错了
    public int eraseOverlapIntervals(int[][] intervals) {
        List<Integer>[] intList = new List[intervals.length];
        for (int i = 0 ; i < intervals.length ; i ++){
            intList[i] = new ArrayList<>();
        }
        for (int i = 0 ; i < intervals.length ; i ++){
            for (int j = i+1 ; j < intervals.length ; j ++){
                if (Math.min(intervals[i][1],intervals[j][1]) > Math.max(intervals[i][0],intervals[j][0])){
                    intList[i].add(j);
                    intList[j].add(i);
                }
            }
        }
        int sum = 0;
        int max = -1;
        while (true) {
            max = -1;
            for (int i = 0; i < intervals.length ; i ++){
                if (max < 0){
                    if (intList[i].size() > 0){
                        max = i;
                    }
                }
                else {
                    if (intList[i].size() > intList[max].size()){
                        max = i;
                    }
                }
            }
            if (max >= 0) {
                sum ++;
                for (Integer x : intList[max]) {
                    intList[x].remove((Integer)max);
                }
                intList[max].clear();
            }
            else {
                break;
            }
        }
        return sum;
    }

    //别人写的，对的
    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 按 end 升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        //统计不重叠的区间个数
        int ans = 1;
        //不包括自己
        for (int i = 1; i < n; ++i) {
            //找到不重叠的区间，则修改right
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        //最后去除最多的不重叠的区间个数，就是最少去除的个数
        return n - ans;
    }

    public static void main(String[] args){
        No435 no435 = new No435();
        System.out.println(no435.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
    }
}
