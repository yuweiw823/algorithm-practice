//Leetcode 027 - Remove Element - 和26题一起看！

public class Solution {
    public static void main(String[] agrs){
      int[] nums = {1,1,2,2,5};
      int s = removeElement(nums, 2);
      System.out.println(s);
    }
  
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;  //new length
    }
}