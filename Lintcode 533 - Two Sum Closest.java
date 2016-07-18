Lintcode 533 - Two Sum Closest.java

public class Solution {
    public int twoSumCloset(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        
        int i = 0;
        int j = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while(i < j) {
            int sum = nums[i] + nums[j];
            diff = Math.min(diff, Math.abs(target - sum));
            if(sum == target) {
                return 0;
            } else if (sum < target) {
                i++;
            } else { //sum > target
                j--;
            }
        }
        return diff;
        
    }
}