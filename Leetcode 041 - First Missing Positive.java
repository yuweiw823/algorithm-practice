//Leetcode 041 - First Missing Positive.java
//交换下标和值
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 1;
        }
        
        for(int i = 0; i < nums.length; i++) {
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1) { //注意while循环
                int temp = nums[i];
                if(nums[temp - 1] == temp) { //双重验证
                    break;
                }else {
                    swap(i, temp - 1, nums);
                }
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return nums.length + 1;
        
    }
    
    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}