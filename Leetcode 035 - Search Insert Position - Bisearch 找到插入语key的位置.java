//Leetcode 034 - Search Insert Position - Bisearch 找到插入语key的位置.java

public class Solution {
    public static void main(String[] args){
        int[] nums = {1,3,6,7};
        int target = 4;
        int result = searchInsert(nums, target);
        System.out.println(result + "");
      
    }
    public static int searchInsert(int[] nums, int target) {
        int L = 0;
        int R = nums.length-1;
        while(L<R){
            int M = (L+R)/2;
            if(nums[M] < target){
                L = M+1;
            } else {
                R = M;
            }
        }
        return (nums[L] < target) ? L+1 : L;
    }
}