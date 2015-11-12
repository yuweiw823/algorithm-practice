Leetcode 172 - Factorial Trailing Zeroes.java
// n的阶乘最后会有多少个0
// 0由2*5得。2不缺，所以只需要看阶乘中有多少个5

public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n>0){
            count += n/5;
            n /= 5;            
        }
        return count;
    }
}