//Leetcode 055 - Jump Game.java

public class Solution {
    public static void main(String[] args){
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums) + "");
    }
//方法1：自己的解法，从左向右扫，和 LeetCode 134 类似
    public static boolean canJump(int[] nums) {
        int stepCanUse = 0;
        for(int i=0; i<nums.length; i++){
            stepCanUse = Math.max(stepCanUse-1, nums[i]);
            if(stepCanUse==0) {
                return (i==nums.length-1);
            }
        }
        return true;
    }
}

//方法2：和方法1类似，看最远的reach
动态
    public static boolean canJump(int[] nums) {
        int reach = 0;
        for(int i=0; i< nums.length; i++){
            if(reach < i) return false;  //注意这句判断！
            reach = Math.max(reach, nums[i]+i);
        }
        return (reach>=nums.length-1);
    }


//方法3：从右向左扫，看最终能到的最左边是哪里  
    public static boolean canJump(int[] nums) {
        int leftMost = nums.length-1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]+i >= leftMost) leftMost = i;
        }
        return leftMost==0;
    }
}