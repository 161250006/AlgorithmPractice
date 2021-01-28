package algorithmClass.firstPractice;

import java.util.*;

class Num {
    private int val;
    private int num;

    public Num(int val) {
        super();
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

public class No25 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(System.in);
        int cases = cin.nextInt();
        int len = 0;
        for (int i = 0; i < cases; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            len = cin.nextInt();
            Num[] input = new Num[len];
            for (int j = 0; j < len; j++) {
                int val = cin.nextInt();
                input[j] = new Num(val);
                if (map.containsKey(val)) {
                    map.put(val, map.get(val) + 1);
                } else {
                    map.put(val, 1);
                }
            }
//            for(Integer ii:map.keySet())
//                System.out.println(ii+" "+map.get(ii));
//            System.out.println(len);
            for(int j=0;j<len;j++){
                input[j].setNum(map.get(input[j].getVal()));
            }
            Arrays.sort(input, new Comparator<Num>() {
                @Override
                public int compare(Num o1, Num o2) {
                    // TODO Auto-generated method stub
                    if (o1.getNum() > o2.getNum())
                        return -1;
                    if (o1.getNum() < o2.getNum())
                        return 1;
                    if (o1.getVal() > o2.getVal())
                        return 1;
                    if (o1.getVal() < o2.getVal())
                        return -1;
                    return 0;
                }
            });
            System.out.print(input[0].getVal());
            for(int j=1;j<len;j++)
                System.out.print(" "+input[j].getVal());
            System.out.println();

        }
    }

}