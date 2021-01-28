package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/12/23 14:17
 * @description：
 */
public class No10 {
    //自己写的，失败了
    public boolean isMatch(String s, String p) {
        int sp = 0;
        int pp = 0;
        while (pp < p.length()){
            char pNow = p.charAt(pp);
            if (pNow == '.'){
                if (pp < p.length() - 1 && p.charAt(pp+1) == '*'){
                    if (pp < p.length() - 2){
                        while (sp < s.length() && s.charAt(sp) != p.charAt(pp+2)){
                            sp ++;
                        }
                        pp ++;
                    }
                    else {
                        return true;
                    }
                }
                else {
                    if (sp < s.length()) {
                        sp++;
                    }
                    else {
                        return false;
                    }
                }
            }
            else{
                if (pp < p.length() - 1 && p.charAt(pp+1) == '*'){
                    while (sp < s.length() && s.charAt(sp) == p.charAt(pp)){
                        sp ++;
                    }
                    pp++;
                }
                else {
                    if (sp > s.length() -1 || s.charAt(sp) != p.charAt(pp)){
                        return false;
                    }
                    sp ++;
                }
            }
            pp++;
        }
        if (sp == s.length()){
            return true;
        }
        else {
            return false;
        }
    }

    //使用dp
    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        //f[0]代表空字符串，mn都各加了一位，其中m从0开始是因为空字符串也需要加入计算,如""可以被".*"匹配
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                //详细公式看题解
                //如果是*，就看前一位是否匹配（i-1)或者放弃*（j-2）
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


    public static void main(String[] args){
        No10 no10 = new No10();
        System.out.println(no10.isMatch("aa",".*"));
    }
}
