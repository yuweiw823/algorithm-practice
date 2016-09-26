//LeetCode 16 - 3Sum Closet



//for 循环在最外面
//只是输出best，所以不用像3sum一样考虑跳过duplicant
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return -1;
        }
        
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(target - sum) < Math.abs(target - bestSum)) {
                    bestSum = sum;
                }
                
                if(sum < target) {
                    start++;
                } else if(sum > target) {
                    end--;
                } else {
                    return bestSum;
                }
            }
        }
        return bestSum;
    }
}