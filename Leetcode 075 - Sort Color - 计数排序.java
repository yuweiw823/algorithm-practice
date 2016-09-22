//Leetcode 075 - Sort Color - 计数排序.java

//Quick Sort
// 用left keep 需要排序的左边界（left 以左，全部是0）
// 用right keep 需要排序的右边界（right 以右，全部是2）
// i用作pointer
public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        
        int i = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while(i <= right) {
            if(nums[i] == 1) {
                i++;
            }else if(nums[i] == 0) {
                swap(left, i, nums);
                i++;
                left++;
            } else {
                swap(i, right, nums);
                right--;
            }
        }
    }
    
    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}



//这个事什么鬼。。。
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