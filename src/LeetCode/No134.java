package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/11/18 10:18
 * @description：
 */
public class No134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum1 = 0 , sum2 = 0;
        for (int i = 0 ; i < gas.length ; i ++){
            sum1 += gas[i];
            sum2 += cost[i];
        }
        if (sum1 < sum2){
            return -1;
        }
        for (int i = 0 ; i < gas.length ; i ++){
            int x = 0;
            int j = i;
            boolean k = false;
            while (j != i || !k) {
                x += gas[j];
                if (cost[j] > x) {
                    break;
                }
                else {
                    x -= cost[j];
                }
                if (j == gas.length - 1){
                    j = 0;
                }
                else {
                    j ++;
                }
                k = true;
            }
            if (j == i && k){
                return j;
            }
        }
        return -1;
    }

    //数学推导，推出访问不到节点，起点和终点中的每个点都访问不到，从而实现跨越循环
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    //图推导出的方法
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }
}
