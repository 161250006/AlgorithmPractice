package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2021/1/1 10:58
 * @description：
 */
public class No605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length){
            if (flowerbed[i] == 0){
                if ((i < flowerbed.length -1 && flowerbed[i+1] == 0) || (i == flowerbed.length - 1)){
                    flowerbed[i] = 1;
                    n --;
                    i++;
                }
            }
            else {
                i++;
            }
            i++;
            if (n <= 0){
                return true;
            }
        }
        return false;
    }
}
