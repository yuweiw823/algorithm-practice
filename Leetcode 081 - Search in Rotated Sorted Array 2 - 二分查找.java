Leetcode 081 - Search in Rotated Sorted Array 2 - 二分查找.java
    //试图使用和033相同的分区域 BiSearch 的解法，在有duplicate的情况下，无法用简单地贪心法找到分片的正确区域
    //比如[3,3,3,1,3,3] [1,1,1,3,1 1]
    //如果 nums[0] == nums[length-1] 使用另外的方法找出各区域的边界
    //这道题是只需boolean，所以其实可以sort一遍后直接一个Bisearch

public class Solution {
    public static void main(String args[]){
        int[] nums = {1,2,5,3,3,6,7,3,5,6,4};
        boolean res = search(nums, 4);
        System.out.println(res + "");
    }
    
    //和 033 相同的 BiSearch 方法
    //TODO: 如果 nums[0] == nums[length-1] 使用另外的方法找出各区域的边界
    public static boolean search(int[] nums, int target) {
        int L = 0;
        int R = nums.length-1;
        while(L<R){
            if(nums[L] <= nums[R]) L++;
            else R--;
        }
        //the largest num in nums, if the largest has duplicates, it stops at the last num.
        int top = L;
        if(L == nums.length-1) {
            return BiSearch(0, L, nums, target);
        } else {
            return BiSearch(0, L, nums, target) || BiSearch(L+1, nums.length-1, nums, target);
        }
    }
    
    public static boolean BiSearch(int start, int end, int[] nums, int key){
        int L= start;
        int R = end;
        while(L<R){
            int M = (L+R)/2;
            if(nums[M] < key) L = M+1;
            else R = M;
        }
        return nums[L]==key;
    }
}


