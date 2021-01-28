package LeetCode;

import java.util.PriorityQueue;

/**
 * @author ：CK
 * @date ：Created in 2020/11/9 10:27
 * @description：
 */
public class No973 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for (int[] p : points){
            if (priorityQueue.size() < K){
                priorityQueue.add(p);
            }
            else {
                priorityQueue.add(p);
                priorityQueue.remove();
            }
        }
        return priorityQueue.toArray(new int[0][]);
    }
}
