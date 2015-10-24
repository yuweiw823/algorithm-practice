//Leetcode 070 - Climbing Stairs - 斐波那契.java
// N    方案数量
// 1     1
// 2     2
// 3     3
// 4     5
// 5     8
// ……
// 即求第N项的斐波那契数列 f(n) = f(n-1)+f(n-2)

public class Solution {
    public int climbStairs(int n) {
        int result = 0;
        int p1 = 1;
        int p2 = 1;
        
        if(n==0) return 0;
        if(n==1) return 1;
        
        int i=2;
        while(i<=n){
            result = p1+p2;
            p2=p1;
            p1=result;
            i++;
        }
        return result;
    }
}