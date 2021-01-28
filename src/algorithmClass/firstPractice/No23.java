package algorithmClass.firstPractice;

import java.util.Scanner;

/**
 * @program: Test
 * @ClassName L.java
 * @description: TODO
 * @author: Jun
 * @version: 1.0.0
 * @create: 2019-11-20 19:44
 */
public class No23{
    public static class Main {
        private int currIndex;
        private int[][] board;

        public Main() {
        }

        public Main(int currIndex, int len) {
            this.currIndex = currIndex;
            this.board = new int[len][len];
        }

        public static void main(String[] args) {
            Scanner cin = new Scanner(System.in);
            int caseNum = Integer.parseInt(cin.nextLine().trim());
            while (caseNum > 0) {
                int[] input1 = StringarrToIntarr(cin.nextLine().trim());
                int[] input2 = StringarrToIntarr(cin.nextLine().trim());
                int Length = (int) Math.pow(2, input1[0]);
//            int[][] board = new int[Length][Length];
                Main ob1 = new Main(0, Length);
                ob1.Separation(0, 0, input1[1], input1[2], Length);

//            for (int i = 0; i < ob1.board.length; i++) {
//                for (int j = 0; j < ob1.board[i].length; j++)
//                    System.out.printf("%4d", ob1.board[i][j]);
//                System.out.printf("\n");
//            }
                String sResult = "";
                int currResultIndex = 0;
                for (int i = input2[0] - 1; i <= input2[0] + 1; i++) {
                    if (i < 0 || i >= Length)
                        continue;
                    for (int j = input2[1] - 1; j <= input2[1] + 1; j++) {
                        if (j < 0 || j >= Length)
                            continue;
                        if (i == input2[0] && j == input2[1])
                            continue;
                        if (ob1.board[i][j] == ob1.board[input2[0]][input2[1]]) {
                            sResult = sResult + i + " " + j;
                            if (currResultIndex == 0)
                                sResult += ",";
                            ++currResultIndex;
                        }
                    }
                }
                System.out.printf("%s\n", sResult);
                --caseNum;
            }
        }

        public static int[] StringarrToIntarr(String string) {
            String[] inputS = string.split(" ");
            int[] output = new int[inputS.length];
            for (int j = 0; j < inputS.length; j++) {
                output[j] = Integer.parseInt(inputS[j]);
            }
            return output;
        }

        public void Separation(int beginX, int beginY, int pointX, int pointY, int boardLen) {
            if (boardLen == 1) {
//            this.board[beginX][beginY] = this.currIndex;
                return;
            }
            int currI = ++this.currIndex;
            boardLen /= 2;
            if (pointX < (beginX + boardLen) && pointY < (beginY + boardLen))
                Separation(beginX, beginY, pointX, pointY, boardLen);
            else {
                this.board[beginX + boardLen - 1][beginY + boardLen - 1] = currI;
                Separation(beginX, beginY, beginX + boardLen - 1, beginY + boardLen - 1, boardLen);
            }

            if (pointX < (beginX + boardLen) && pointY >= (beginY + boardLen))
                Separation(beginX, beginY + boardLen, pointX, pointY, boardLen);
            else {
                this.board[beginX + boardLen - 1][beginY + boardLen] = currI;
                Separation(beginX, beginY + boardLen, beginX + boardLen - 1, beginY + boardLen, boardLen);
            }

            if (pointX >= (beginX + boardLen) && pointY < (beginY + boardLen))
                Separation(beginX + boardLen, beginY, pointX, pointY, boardLen);
            else {
                this.board[beginX + boardLen][beginY + boardLen - 1] = currI;
                Separation(beginX + boardLen, beginY, beginX + boardLen, beginY + boardLen - 1, boardLen);
            }

            if (pointX >= (beginX + boardLen) && pointY >= (beginY + boardLen))
                Separation(beginX + boardLen, beginY + boardLen, pointX, pointY, boardLen);
            else {
                this.board[beginX + boardLen][beginY + boardLen] = currI;
                Separation(beginX + boardLen, beginY + boardLen, beginX + boardLen, beginY + boardLen, boardLen);
            }
        }

        public int getBoard(int lX, int lY) {
            return board[lX][lY];
        }

        public void setBoard(int lX, int lY, int val) {
            this.board[lX][lY] = val;
        }

        public int getCurrIndex() {
            return currIndex;
        }

        public void setCurrIndex(int currIndex) {
            this.currIndex = currIndex;
        }
    }

}
