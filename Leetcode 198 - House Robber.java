Leetcode 198 - House Robber.java

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int[] result = new int[len + 1];
        
        result[0] = 0;
        result[1] = nums[0];
        
        for(int i = 2; i <= len; i++) {
            result[i] = Math.max(result[i - 1], nums[i - 1] + result[i - 2]);
        }
        
        return result[len];
    }
}