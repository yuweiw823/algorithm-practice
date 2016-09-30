Leetcode 189 - Rotate Array.java

public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }
        
        int n = nums.length;
        k = k % n;
        rotateSub(nums, 0, n - 1 - k);
        rotateSub(nums, n - k, n - 1);
        rotateSub(nums, 0, n - 1);
        
    }
    
    public void rotateSub(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}