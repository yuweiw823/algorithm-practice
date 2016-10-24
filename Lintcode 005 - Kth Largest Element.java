Lintcode 005 - Kth Largest Element.java

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        return quickSelect(nums, 0, nums.length - 1, nums.length + 1 - k);
    }
    
    public int quickSelect(int[] nums, int start, int end, int k) {
        if(start == end) {
            return nums[start];
        }
        
        int pos = partition(nums, start, end);
        if(pos + 1 == k) {
            return nums[pos];
        } else if(pos + 1 < k) {
            return quickSelect(nums, pos + 1, end, k);
        } else {
            return quickSelect(nums, start, pos - 1, k);
        }

    }
    
    public int partition(int[] nums, int start, int end) {
        int left = start;
        int right = end;
        int pivot = nums[left];
        
        while(left < right) {
            while(left < right && right >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while(left < right && left <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        
        nums[left] = pivot;
        return left;
    }
};