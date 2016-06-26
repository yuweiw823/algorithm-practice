Lintcode 076 - Longest Increasing Subsequence.java
http://www.lintcode.com/en/problem/longest-increasing-subsequence/
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    // nums[4, 2, 4, 5, 3, 7]
    // longest incre sub from 0 - i
    // f   [1]
    //     [1, 1]
    //     [1, 1, 2]
    //     [1, 1, 2, 3]
    //     [1, 1, 2, 3, 1]
    //     [1, 1, 2, 3, 1, 4]
    
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[] f = new int[len];
        int max = 1;
        
        for(int i = 0; i < len; i++) {
            f[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] <= nums[i]){ //increse
                    f[i] = Math.max(f[j] + 1, f[i]);
                }
            }
            max = Math.max(max, f[i]);
        }
        
        return max;
    }
}
