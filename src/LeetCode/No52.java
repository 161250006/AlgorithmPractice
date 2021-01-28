package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/10/17 10:09
 * @description：
 */
public class No52 {
    int sum;
    public int totalNQueens(int n) {
        char[][] chs=new char[n][n];
        sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chs[i][j]='.';
            }
        }
        backTracing(chs,0,n);
        return sum;
    }
    public void backTracing(char[][] chs,int row,int n){
        //每行都摆满皇后时，则产生了一种解法
        if(row==n){
            sum++;
            return;
        }
        //一行一行地摆放，在确定一行中的那个皇后应该摆在哪一列时，需要当前列是否合法。
        //如果合法，则将皇后放置在当前位置，并进行递归，回溯。
        for(int col=0;col<chs[0].length;col++){
            if(isValid(chs,row,col)){
                chs[row][col]='Q';
                //递归
                backTracing(chs,row+1,n);
                //回溯
                chs[row][col]='.';
            }
        }
    }
    //判断合法：当前将要摆放'Q'的位置和其他已摆放‘Q’的位置不能在同一列，且不能在同一条45度斜线或135度斜线上。
    //这里判断是否在同一条斜线上可通过当前将要摆放'Q'的位置和其他已摆放‘Q’的位置横坐标之差和纵坐标之差的绝对值是否相等来判断。
    public boolean isValid(char[][] chs,int x,int y){
        for(int i=0;i<=x;i++){
            for(int j=0;j<chs[0].length;j++){
                if(chs[i][j]=='Q'&&(j==y||Math.abs(x-i)==Math.abs(y-j))){
                    return false;
                }
            }
        }
        return true;
    }
}
