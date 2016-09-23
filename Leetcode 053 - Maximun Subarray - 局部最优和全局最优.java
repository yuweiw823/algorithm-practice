//Leetcode 053 - Maximun Subarray - 局部最优和全局最优.java
//可以和 055 - Jump Game 一起看

public class Solution {
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1-5};
        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = Integer.MIN_VALUE; //全局的max
        int sum = 0; //局部的，sum一旦变成到负数，sum = 0；
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        
        return max;
    }
}