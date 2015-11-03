Leetcode 166 - Fraction to Recurring Decimal - 细节题烦人.java

import java.util.*;

public class Solution {
    public static void main(String[] args){
        String res = fractionToDecimal(-2147483648, 1);
//         String res = (7 % -12) + "";
        System.out.println(res);
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return null;
        if(numerator == 0) return "0";
        boolean isPositive = true;
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) isPositive = false;
        StringBuffer res = new StringBuffer();
        
        long numeratorL = Math.abs((long)numerator);  //必须先转long再取绝对值
        long denominatorL = Math.abs((long)denominator);
        long intRes = numeratorL / denominatorL;
        long mode = numeratorL % denominatorL;
        
        res.append(intRes);
        if(mode != 0) res.append(".");
        
        // 之前使用int[]，借助下标标注位置，但这种做法不对，因为mode可能是两位、三位数。应使用HashMap
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        int pos = 0;
        while(mode != 0){
            long num = mode * 10;
            long resDigit = num/denominatorL;
            if(!map.containsKey(mode)){
                res.append(resDigit);
                map.put(mode, pos++);
            } else {
                int firstIndex = map.get(mode) + res.indexOf(".") +1;
                res.insert(firstIndex, '(');
                res.append(')');
                break;
            }
            mode = num % denominatorL;
        }
        if(!isPositive) res.insert(0, '-');
        
        return res.toString();
    }
}