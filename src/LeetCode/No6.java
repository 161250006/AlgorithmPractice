package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：CK
 * @date ：Created in 2020/10/12 9:45
 * @description：
 */
public class No6 {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        String[][] strings = new String[numRows][(s.length()/(2 * numRows - 2) + 1)*(numRows - 1)];
        int x = 0, y = 0, z = 0;
        for (int i = 0 ; i < s.length() ; i ++){
            strings[x][y] = s.substring(i,i+1);
            if (z == 0) {
                if (x == numRows - 1) {
                    x--;
                    y++;
                    z = 1;
                }
                else {
                    x++;
                }
            }
            else {
                if (x == 0){
                    x++;
                    z = 0;
                }
                else {
                    x--;
                    y++;
                }
            }
        }
        String result = "";
        for (int i = 0 ; i < numRows ; i++){
            for (int j = 0 ; j <= y ;j++){
                if (strings[i][j] != null){
                    result += strings[i][j];
                }
            }
        }
        return result;
    }

    //二维数组变为一维数组，使用stringbuilder
    public String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
