Leetcode 268 - Missing Number.java


提供了三种方法：
https://discuss.leetcode.com/topic/23427/3-different-ideas-xor-sum-binary-search-java-code

由于从0开始，如果不缺 nums[i] 和 i 应该相等（sort后）。
1. 球全部的Sum再依次相减
2. nums[i] 和 i 异或
3. 先sort，nums[mid] 和 mid 比较的 Binary Search


public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length + 1;
        int sum = (0 + n) * (n - 1) / 2;
        
        for(int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        
        return sum;
    }
}