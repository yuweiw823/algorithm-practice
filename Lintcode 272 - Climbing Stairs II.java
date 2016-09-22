Lintcode 272 - Climbing Stairs II.java

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        // Write your code here
        if(n <= 1) {
            return 1;
        }
        
        if(n == 2) {
            return 2;
        }
        
        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;
        steps[2] = 2;
        
        
        for(int i = 3; i <= n; i++) {
            steps[i] = steps[i - 3] + steps[i - 2] + steps[i - 1];
        }
        
        return steps[n];
    }
}