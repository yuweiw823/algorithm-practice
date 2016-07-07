//http://www.lintcode.com/en/problem/find-minimum-in-rotated-sorted-array/
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//Leetcode 153 - Find Minimum in Rotated Sorted Array
//Lintcode 159 - ind Minimum in Rotated Sorted Array
public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        //关键：mid 和 end 进行比较
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] >= nums[end]) {
                start = mid;
            } else if(nums[mid] < nums[end]) {
                end = mid;
            }
        };
        
        return Math.min(nums[start], nums[end]);
    }
}