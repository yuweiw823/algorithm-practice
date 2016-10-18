Leetcode 347 - Top K Frequent Elements.java


//方法1：keep一个minHeap，新加入的数比minHeap中最小的大，就替换掉minHeap中最小的数
//就像打天梯一样，总是把最小的干掉



//方法2：QuickSelect，Quick Select只需要递归一边就可以，而Quick Sort要递归两边






//不好的方法：把全部quick Sort一遍，NlogN
class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        int[] temp = new int[k];
        if(nums == null || nums.length == 0) {
            return temp;
        }
        quickSort(nums, 0, nums.length - 1, k);
        
        if(nums.length < k) {
            return nums;
        }
        
        for(int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }
        
        return temp;
    }
    
    public void quickSort(int[] nums, int start, int end, int k) {
        if (start >= end) {
            return;
        }
        
        int left = start, right = end;
        int mid = left + (right - left) / 2;
        int pivot = nums[mid];
        
        while(left <= right) {
            while(left <= right && nums[left] > pivot) {
                left++;
            }
            
            while(left <= right && nums[right] < pivot) {
                right--;
            }
            
            if(left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        
        quickSort(nums, start, right, k);
        quickSort(nums, left, end, k);
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
};

