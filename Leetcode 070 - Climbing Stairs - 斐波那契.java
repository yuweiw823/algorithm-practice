//Leetcode 070 - Climbing Stairs - 斐波那契.java
// N    方案数量
// 1     1
// 2     2
// 3     3
// 4     5
// 5     8
// ……
// 即求第N项的斐波那契数列 f(n) = f(n-1)+f(n-2)


//标准 DP 格式写法：但这种写法太耗空间
public class Solution {
    public int climbStairs(int n) {
        if(n <= 1) {
            return 1;
        }
        
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        
        for(int i = 2; i <= n; i++){
            steps[i] = steps[i-1] + steps[i-2];
        }
        
        return steps[n];
    }
}

//简化写法：
public class Solution {
    public int climbStairs(int n) {
        if(n <= 1) {
            return 1;
        }
        
        int sum = 0;
        int last = 1, lastlast = 1;
        
        for(int i=2; i<=n ;i++) {
            sum = last + lastlast;
            lastlast = last;
            last = sum;
        }
        return sum;
    }
}