Leetcode 169 - Majority Element - Moore 投票.java


//Moore voting algorithm

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int curr = nums[0];
        for(int i=0; i<nums.length; i++){
            if(count == 0){
                curr = nums[i];
                count = 1;
            }
            else if(curr == nums[i]) count++;
            else count--;
        }
        return curr;
    }
}