Leetcode 031 - Next Permutation - while 循环使用.java


public class Solution {
    public static void main(String[] args){
        int[] nums1 = {1,2,3};
        nextPermutation(nums1);
        for(int i : nums1){
            System.out.print(i + ", ");
        }
        System.out.println("");
      
        int[] nums2 = {2,3,6,5,4,1};
        nextPermutation(nums2);
        for(int j : nums2){
            System.out.print(j + ", ");
        }
    }
    public static void nextPermutation(int[] nums) {
        if (nums.length==0 || nums == null) return;
        int len = nums.length;
        int swapStart = -1;
        int swapEnd = len-1;
        
        int i = len-2;              //Step 1,从后往前找到第一个不是升序排列的数
        while(i>=0 && nums[k] >= nums[k+1]){
            k--;
        }
        swapStart = k;
            
        if(swapStart != -1){ 
            int i = swapStart+1;    //Step 2，找到后面第一个小于swapStart的数
            while(i<len && nums[i] > nums[swapStart]){
                i++;
            }
            swapEnd = i-1;          //的前一个数
            swap(nums, swapStart, swapEnd);  //交换两个数
        }
        reverse(nums, swapStart+1, len-1);   //Step 3，swapStart后的数组整个倒序
    }
    
    public static void reverse(int[] nums, int l, int r){
        while(l<r){
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    
    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
