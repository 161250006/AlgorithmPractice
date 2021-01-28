package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2021/1/13 11:19
 * @description：
 */
public class No684 {
    public int[] findRedundantConnection(int[][] edges) {
        BCJ bcj = new BCJ(edges.length + 1);
        for (int i = 0 ; i < edges.length ; i ++){
            if (bcj.find(edges[i][1]) != bcj.find(edges[i][0])) {
                bcj.union(edges[i][0], edges[i][1]);
            }
            else {
                return edges[i];
            }
        }
        return null;
    }
    public class BCJ{
        int[] parent;
        public BCJ(int n){
            parent = new int[n];
            for (int i = 0 ; i < n ; i ++){
                parent[i] = i;
            }
        }

        public void union(int x , int y){
            parent[find(y)] = find(x);
        }
        public int find(int x){
            return parent[x] == x ? x : find(parent[x]);
        }
    }
}
