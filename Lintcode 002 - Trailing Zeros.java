Lintcode 002 - Trailing Zeros.java

class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        //only 2 and 5 can generate 0
        //for 11 as example 2, 5, 4, 10
        //由于2肯定足够，所以完全取决于有多少个5
        //但有25的要格外注意。
        //5^1, 5^2, 5^3
        if(n <= 0) {
            return (long)(0);
        }
        long powerOf5 = 5;
        long count = 0;
        while(n / powerOf5 > 0) {
            count += (n / powerOf5);
            powerOf5 *= 5;    
        }
        
        return count;
        
    }
};
