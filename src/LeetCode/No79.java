package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/9/13 10:12
 * @description：
 */
public class No79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] exist = new boolean[board.length][board[0].length];
        for (int x = 0; x < board.length ; x++){
            for (int y = 0; y < board[0].length ; y++){
                if (board[x][y] == word.charAt(0)) {
                    exist[x][y] = true;
                    if (search(board, word, x, y, 1, exist)) {
                        return true;
                    }
                    exist[x][y] = false;
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board, String word, int xNow, int yNow, int k, boolean[][] exist){
        if (k == word.length()){
            return true;
        }
        if (xNow > 0 && !exist[xNow - 1][yNow] && board[xNow -1][yNow] == word.charAt(k)){
            exist[xNow - 1][yNow] = true;
            if (search(board, word, xNow - 1, yNow, k + 1, exist)){
                return true;
            }
            exist[xNow - 1][yNow] = false;
        }
        if (yNow > 0 && !exist[xNow][yNow - 1] && board[xNow][yNow - 1] == word.charAt(k)){
            exist[xNow][yNow - 1] = true;
            if (search(board, word, xNow, yNow - 1, k + 1, exist)){
                return true;
            }
            exist[xNow][yNow - 1]= false;
        }
        if (xNow < board.length - 1 && !exist[xNow + 1][yNow] && board[xNow +1][yNow] == word.charAt(k)){
            exist[xNow + 1][yNow] = true;
            if (search(board, word, xNow + 1, yNow, k + 1, exist)){
                return true;
            }
            exist[xNow + 1][yNow] = false;
        }
        if (yNow < board[0].length - 1 && !exist[xNow][yNow + 1] && board[xNow][yNow + 1] == word.charAt(k)){
            exist[xNow][yNow + 1] = true;
            if (search(board, word, xNow, yNow + 1, k + 1, exist)){
                return true;
            }
            exist[xNow][yNow + 1]= false;
        }
        return false;
    }
    public static void main(String[] args){
        char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        No79 no79 =new No79();
        System.out.println(no79.exist(board,"AAB"));
    }
}
