Leetcode 153 - Find Minimum in Rotated Sorted Array.java

public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if(nums[mid] < nums[end]){ // < nums[start]一定要先写 mid < end，因为array可能没翻转
                end = mid;
            } else if(nums[mid] > nums[start]){ //> nums[end]
                start = mid;
            }
        }
        
        if(nums[start] <= nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }

}