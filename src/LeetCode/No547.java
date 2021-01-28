package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2021/1/7 11:20
 * @description：
 */
public class No547 {
    //我写的dfs
    public int findCircleNum(int[][] isConnected) {
        int sum = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0 ; i < visited.length ; i ++){
            if (!visited[i]){
                sum++;
                dfs(isConnected,visited,i);
            }
        }
        return sum;
    }

    public void dfs(int[][] isConnected , boolean[] visited, int index){
        for (int i = 0 ; i < isConnected.length ; i ++){
            if (i != index && isConnected[index][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(isConnected,visited,i);
            }
        }
    }

    //并查集
    public int findCircleNum1(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            //父亲节点自己的就是某一组的根节点
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    //合并两个节点，第二个作为第一个的父亲节点
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    //找父亲节点，并进行路径压缩，合并的时候会进行路径压缩
    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
