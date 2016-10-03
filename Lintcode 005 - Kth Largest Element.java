Lintcode 005 - Kth Largest Element.java

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    
    public int kthLargestElement(int k, int[] nums) {
        if(nums == null || nums.length == 0 || nums.length < k) {
            return -1;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    
    public void quickSort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        
        int left = start;
        int right = end;
        int pivot = nums[start + (end - start) / 2];
        while(left <= right) {
            while(left <= right && nums[left] < pivot) {
                left++;
            }
            while(left <= right && nums[right] > pivot) {
                right--;
            }
            if(left <= right) {
                swap(left, right, nums);
                left++;
                right--;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
    
    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }    
};