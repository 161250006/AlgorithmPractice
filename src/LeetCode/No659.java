package LeetCode;

import java.util.*;

/**
 * @author ：CK
 * @date ：Created in 2020/12/4 10:40
 * @description：
 */
public class No659 {
    //自己写的，失败了
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(nums.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]>o2[1]){
                    return -1;
                }
                else if (o1[1]<o2[1]){
                    return 1;
                }
                else {
                    return o1[0]-o2[0];
                }
            }
        });
        Map<Integer, int[]> map = new HashMap<>();
        for (int i : nums){
            int[] inti = map.getOrDefault(i,new int[]{i,0});
            inti[1] += 1;
            map.put(i,inti);
        }
        for (int i : map.keySet()){
            priorityQueue.offer(map.get(i));
        }
        while (!map.isEmpty()){
            int[] x = priorityQueue.peek();
            int sum = 0;
            int i = x[0];
            while (map.containsKey(i)){
                int[] y = map.get(i);
                sum++;
                y[1] -= 1;
                if (y[1] == 0){
                    map.remove(i);
                    priorityQueue.remove(y);
                }
                else {
                    priorityQueue.remove(y);
                    priorityQueue.offer(y);
                }
                i ++;
            }
            if (sum < 3){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        No659 no659 = new No659();
        System.out.println(no659.isPossible(new int[]{1,2,3,3,4,4,5,5}));
    }

    //大根堆实现，这是人能想出来的方法吗？？？
    public boolean isPossible1(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<Integer>());
            }
            if (map.containsKey(x - 1)) {
                int prevLength = map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                map.get(x).offer(prevLength + 1);
            } else {
                map.get(x).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
