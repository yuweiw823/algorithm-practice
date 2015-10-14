// Leetcode 029 - Divide Two Integers - Recursion, Type.java
  
public class Solution {
    public static void main(String[] args){
        int res = divide(25, 3);
        System.out.println(res + "");
    }
  
    public static int divide(int dividend, int divisor) {
        long result = divideLong(dividend, divisor);
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)result;  //这里需要用(int)将result类型转化
    }
  
    public static long divideLong(long dividend, long divisor){
        //符号处理
        int sign = ((dividend < 0) != (divisor < 0)) ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        //return 处理
        if (dividend < divisor) return 0;
        //具体运算
        long subtra = divisor;
        long count = 1;
        while (subtra + subtra <= dividend){
            subtra += subtra;
            count += count;
        }
        //recursion
        long res = count + divideLong(dividend-subtra, divisor);
        return (sign == 1) ? res : res * (-1);
    }
}





//数字相关题都需要考虑的：符号、越界
example: 23/2
divident, subtra, count, divisor
	23		-		-		2
	23		2 		1
	23		4		2
	23		8		4			
	23		16		8

	23 < 16+16, next recursion, 23-16=7   ------ return 4+7=11 ----final result

	7		2 		1
	7		4		2
	7 < 4+4, next recursion, 7-4=3  ------ return 1+3=4

	3		2 		1
	3 < 2+2, next recursion, 3-2=1  ------ return 1+0=1


	1 < 2, 							------ return 0 
		