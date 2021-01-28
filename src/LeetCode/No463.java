package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/10/30 10:16
 * @description：
 */
public class No463 {
    private int sumP = 0;
    public int islandPerimeter(int[][] grid) {
        int x = 0, y = 0;
        for (int i = 0 ; i < grid.length ; i ++){
            for (int j = 0 ; j < grid[0].length ; j ++){
                if (grid[i][j] == 1){
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        dfs(grid, x, y);
        return sumP;
    }
    public void dfs(int[][] grid, int i, int j){
        sumP += getP(grid, i, j);
        grid[i][j] = -1;
        if (i != grid.length-1 && grid[i+1][j] == 1){
            dfs(grid, i+1, j);
        }
        if (i != 0 && grid[i-1][j] == 1){
            dfs(grid, i-1, j);
        }
        if (j != grid[0].length-1 && grid[i][j+1] == 1){
            dfs(grid, i, j + 1);
        }
        if (j != 0 && grid[i][j-1] == 1){
            dfs(grid, i, j - 1);
        }
    }
    public int getP(int[][] grid, int i, int j){
        int p = 0;
        if (i == grid.length -1 || grid[i+1][j] == 0){
            p++;
        }
        if (i == 0 || grid[i-1][j] == 0){
            p++;
        }
        if (j == grid[0].length -1 || grid[i][j+1] == 0){
            p++;
        }
        if (j == 0 || grid[i][j-1] == 0){
            p++;
        }
        return p;
    }
}
