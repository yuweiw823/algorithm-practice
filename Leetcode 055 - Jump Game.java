//Leetcode 055 - Jump Game.java

//方法1：自己的解法，和 LeetCode 134 类似
public class Solution {
    public static void main(String[] args){
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums) + "");
    }
  
    public static boolean canJump(int[] nums) {
        int stepCanUse = 0;
        for(int i=0; i<nums.length; i++){
            stepCanUse = Math.max(stepCanUse-1, nums[i]);
            if(stepCanUse==0) {
                return i==nums.length-1 ? true : false;
            }
        }
        return true;
    }
}

//方法2：