// Leetcode 080 - Remove Duplicates from Sorted Array 2 - 参考026.java

import java.util.*;

public class Solution {
    public static void main(String args[]){
        int[] nums = {1, 1, 1, 2, 2, 2, 2, 3};
        int res = removeDuplicates(nums);
        System.out.println(res + "");
    }
  
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        int count = 0;
        
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]){  //控制从 i==1开始比较，同时又在 i==0 时使 count = 1
                count++;
                if(count>=3) continue;
            } else {
                count=1; //i==0时，count = 1；
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}