//Leetcode 026 - Remove Element - specific loop.java
//看上去简单但很有技巧的一题。不要像 2Sum 系列一样写 while loop，写 for loop，注意 index 

public class Solution {
    public static void main(String[] agrs){
      int[] nums = {1,1,2,2,5};
      int s = removeDuplicates(nums);
      System.out.println("    "+s);
    }
  
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        Arrays.sort(nums);
        
        int index = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != nums[index]){
                index++;
                nums[index] = nums[i];  //重要的一行！
            }
        }
        return index+1;
    }
}
