Leetcode 152 - Maximum Product Subarray.java

和 Maximum Subarray 类似，但还必须保存一个smallest的值，因为smallest可能为负数，一旦x另一个负数，有可能变为最大值。

public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        
        int global_max = nums[0];
        int global_min = nums[0];
        int res = nums[0];
        for(int i=1; i<nums.length; i++){
            int max = global_max;
            int min = global_min;
            //nums[i],nums[i]*max, nums[i]*min 三者取最小
            global_min = Math.min(Math.min(nums[i], nums[i]*min),nums[i]*max);
            //nums[i],nums[i]*max, nums[i]*min 三者取最大
            global_max = Math.max(Math.max(nums[i], nums[i]*min),nums[i]*max);
            res = Math.max(res, global_max);
        }
        return res;
    }
}