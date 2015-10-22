//Leetcode 053 - Maximun Subarray - 局部最优和全局最优.java
//可以和 055 - Jump Game 一起看

public class Solution {
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1-5};
        System.out.println(maxSubArray(nums));
    }
    //local[i+1]=Math.max(A[i], local[i]+A[i]) 
    //是下一个数 nums[i] 单独，和 nums[i]+local 比较，
    //如果下一个数 nums[i] 是负数，会出现新的 local 比原先的 local 小的情况，所以要用一个global来track
    //global[i+1]=Math.max(local[i+1], global[i])
    public static int maxSubArray(int[] nums) {
        int local_max = nums[0];
        int global_max = nums[0];
        for(int i=1; i<nums.length; i++){
            local_max = Math.max(nums[i], nums[i]+local_max);
            global_max = Math.max(global_max, local_max);
        }
        return global_max;
    }

}