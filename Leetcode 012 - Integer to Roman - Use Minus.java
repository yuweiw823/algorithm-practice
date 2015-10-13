//Leetcode 012 - Integer to Roman - Use Minus.java
//纯使用减法

public class Solution {
    public static final int[] values = {
        1000, 900, 500, 400,
        100, 90, 50, 40,
        10, 9, 5, 4,
        1
    };
    public static final String[] symbols = {
        "M", "CM", "D", "CD",
        "C", "XC", "L", "XL",
        "X", "IX", "V", "IV",
        "I"
    };
    //纯使用减法
    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i=0;i<values.length;i++){
            while (num-values[i] >= 0){
                roman.append(symbols[i]);
                num -= values[i];
            }
        }
        return roman.toString();
    }
}