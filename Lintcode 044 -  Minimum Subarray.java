Lintcode 44 -  Minimum Subarray.java

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0) {
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i< nums.size(); i++) {
            sum += nums.get(i);
            min = Math.min(min, sum);
            sum = Math.min(sum, 0);
        }
        return min;
    }
}
