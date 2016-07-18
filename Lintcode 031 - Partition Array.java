 Lintcode 31 - Partition Array.java

public class Solution {
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums == null || nums.length == 0) {
	        return 0;
	    }
	    int left = 0, right = nums.length - 1;
	    int i = 0;
	    //和 Sort Color 一样的算法
	    while(i <= right) {
            if(nums[i] == k) {
                i++;
            } else if(nums[i] < k) {
                swap(nums, i, left);
                i++;
                left++;
            } else {
	            swap(nums, i, right);
	            right--;
	        }
	    }
	    
	    if(right < 0) {
	        return 0;
	    } else if(left > nums.length -1) {
	        return nums.length;
	    } else {
	        return left;
	    }
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}