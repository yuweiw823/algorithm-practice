Leetcode 162 - Find Peak Element.java

贪心法
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int L = 0;
        int R = nums.length-1;
        while(L<R){
            if(nums[L] <= nums[R]) L++;
            else R--;
        }
        return L;
    }
}

设置一个peak，每一项都跟它比较
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int peak = Integer.MIN_VALUE;
        int p = 0;

        for(int i=0; i<nums.length; i++){
            if(peak <= nums[i]){
                peak = nums[i];
                p = i;
            }
        }
        return p;
    }
}
如果不需要求index，peak = Math.max(peak, nums[i]) 即可