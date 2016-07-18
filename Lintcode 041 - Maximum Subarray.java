Lintcode 41 - Maximum Subarray.java

public class Solution {
    //方法1：Greedy
    public int maxSubArray(int[] nums) {
        // write your code
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        
        return max;
    }
}

