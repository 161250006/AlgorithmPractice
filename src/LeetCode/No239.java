package LeetCode;

import java.util.*;

/**
 * @author ：CK
 * @date ：Created in 2021/1/2 10:48
 * @description：
 */
public class No239 {
    //滑动窗口，不能remove，要记录每个数字的位置，然后判断一个个poll，否则会超时
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[1] != pair2[1] ? pair2[1] - pair1[1] : pair2[0] - pair1[0];
            }
        });
        for (int i = 0 ; i < k ; i ++){
            priorityQueue.offer(new int[]{i,nums[i]});
        }
        result[0] = priorityQueue.peek()[1];
        for (int i = 1 ; i <= nums.length-k; i ++){
            priorityQueue.offer(new int[]{i+k-1,nums[i + k - 1]});
            while (priorityQueue.peek()[0] < i){
                priorityQueue.poll();
            }
            result[i] = priorityQueue.peek()[1];
        }
        return result;
    }

    //双向单调队列，里面记录的是数字的下标，按从大到小排列，每次在右边加入新元素后，按单调栈移除老元素，然后在左边移除老元素后得到最大值。
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
