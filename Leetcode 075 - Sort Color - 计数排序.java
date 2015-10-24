//Leetcode 075 - Sort Color - 计数排序.java

public class Solution {
    public static void main(String[] args){
        int[] nums = {2,1,2,0,1,1,1,0};
        sortColors(nums);
        for(int color : nums){
            System.out.print(color + ",");
        }
    }
    public static void sortColors(int[] nums) {
        //计数排序，用一个数组 count 记录每一个color出现的次数
        int[] count = new int[3];
        for(Integer color : nums){
            count[color]++;
        }
        int color = 0;
        int i = 0;
        while(color<3){
            while(count[color] > 0){
                nums[i] = color;
                i++;
                count[color]--;
            }
            color++;
        }
        
    }
}