package LeetCode;

/**
 * @author ：CK
 * @date ：Created in 2020/12/25 22:34
 * @description：
 */
public class No12 {
    //就不能建个表，用一下表驱动（不-^-)
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        while (num > 0){
            if (num >= 1000){
                num -= 1000;
                result.append("M");
            }
            else if (num >= 900){
                num -= 900;
                result.append("CM");
            }
            else if (num >= 500){
                num -= 500;
                result.append("D");
            }
            else if (num >= 400){
                num -= 400;
                result.append("CD");
            }
            else if (num >= 100){
                num -= 100;
                result.append("C");
            }
            else if (num >= 90){
                num -= 90;
                result.append("XC");
            }
            else if (num >= 50){
                num -= 50;
                result.append("L");
            }
            else if (num >= 40){
                num -= 40;
                result.append("XL");
            }
            else if (num >= 10){
                num -= 10;
                result.append("X");
            }
            else if (num >= 9){
                num -= 9;
                result.append("IX");
            }
            else if (num >= 5){
                num -= 5;
                result.append("V");
            }
            else if (num >= 4){
                num -= 4;
                result.append("IV");
            }
            else{
                num -= 1;
                result.append("I");
            }
        }
        return result.toString();
    }

    //表驱动法，从大的开始贪心，一直到小的，这种累加的都可以用
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman1(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    //按十进制硬编码。。。是真的硬，不建议使用
    public String intToRoman2(int num) {

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }

}
