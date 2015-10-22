//Leetcode 045 - Jump Game 2.java

public class Solution {
	public static void main(String[] args){
	    int[] nums1 = {2,3,1,1,4};
	    int[] nums2 = {2,3,1,2,0,1};
	    int[] nums3 = {0};
	    System.out.println(jump(nums1)+ "");
	    System.out.println(jump(nums2)+ "");
	    System.out.println(jump(nums3)+ "");
    }

//方法1：自己的解法，但这种解法有问题，放弃
	public static int jump(int[] nums) {
	    int stepCanUse = 0;
	    int count = 0;
	    for(int i=0; i<nums.length; ++i){
	        if(stepCanUse-1 < nums[i]){
	            stepCanUse = nums[i];
	                count++;
	        } else {
	            stepCanUse -= 1;
	        }
	    }
	    return count;
	}

//方法2：看最远的reach
	public static int jump(int[] nums) {
        int curr = 0, reach = 0, count = 0;
        for(int i=0; i<nums.length; i++){
        	// curr < i 就是要跳的时候，不需要考虑是否一定能跳到最后一位，
            if(curr < i){
                curr = reach;
                count++;
            }
            //the maximun can be reached for i+1
            reach = Math.max(reach, nums[i]+i);
        }
        return count;
    }
}