Lintcode 148 - Sort Colors.java

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return;
        }
        
        int left = 0;
        int right = nums.length-1;
        int i = 0;
        while(i <= right) {
            if(nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++; //可以++，i之前的数都处理过了
            } else { //nums[i] == 2
                swap(nums, i, right);
                right--;
                //i++; 这里不能++，有可能换过来的是2，2还需重走 while 循环
            }
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}