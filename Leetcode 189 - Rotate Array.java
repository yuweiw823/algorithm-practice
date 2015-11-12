Leetcode 189 - Rotate Array.java

public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length <= 1) return;
        int n = nums.length;
        k = k%n;
        swap(nums, 0, n-1);
        swap(nums, 0, k-1);
        swap(nums, k, n-1);
        return;
    }
    
    public void swap(int[]nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end--;
        }
        return;
    }
}