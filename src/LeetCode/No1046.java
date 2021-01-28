package LeetCode;

import java.util.PriorityQueue;

/**
 * @author ：CK
 * @date ：Created in 2020/12/30 11:00
 * @description：
 */
public class No1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(stones.length,(o1,o2) -> o2-o1);
        for (int i = 0 ; i < stones.length ; i ++){
            priorityQueue.offer(stones[i]);
        }
        while (priorityQueue.size() >= 2){
            int x1 = priorityQueue.poll();
            int x2 = priorityQueue.poll();
            if (x1 != x2){
                priorityQueue.offer(x1 - x2);
            }
        }
        return priorityQueue.isEmpty()?0:priorityQueue.poll();
    }
}
