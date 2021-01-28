package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：CK
 * @date ：Created in 2020/11/17 9:15
 * @description：
 */
public class No1030 {
    //bfs
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] map = new boolean[R][C];
        int[][] result = new int[R*C][2];
        queue.offer(new int[]{r0,c0});
        map[r0][c0] = true;
        int i = 0;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            result[i] = now;
            i ++;
            if (now[0] > 0 && !map[now[0]-1][now[1]]){
                map[now[0]-1][now[1]] = true;
                queue.offer(new int[]{now[0]-1,now[1]});
            }
            if (now[1] > 0 && !map[now[0]][now[1]-1]){
                map[now[0]][now[1]-1] = true;
                queue.offer(new int[]{now[0],now[1]-1});
            }
            if (now[0] < R - 1 && !map[now[0]+1][now[1]]){
                map[now[0]+1][now[1]] = true;
                queue.offer(new int[]{now[0]+1,now[1]});
            }
            if (now[1] < C-1 && !map[now[0]][now[1]+1]){
                map[now[0]][now[1]+1] = true;
                queue.offer(new int[]{now[0],now[1]+1});
            }
        }
        return result;
    }

    //桶排序
    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<List<int[]>>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i, j, r0, c0);
                bucket.get(d).add(new int[]{i, j});
            }
        }
        int[][] ret = new int[R * C][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                ret[index++] = it;
            }
        }
        return ret;
    }

    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

}
