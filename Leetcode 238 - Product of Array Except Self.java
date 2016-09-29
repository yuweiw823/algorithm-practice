Leetcode 238 - Product of Array Except Self.java


//构建一个从后向前的预处理数组的方法，但需要extra 的 array 数组
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        if(nums == null || nums.length == 0) {
            return nums;
        }
        
        int[] product = new int[nums.length];
        
        product[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            product[i] =  product[i + 1] * nums[i + 1];
        }
        
        int prevPro = 1;
        for(int i = 0; i < nums.length; i++) {
            result[i] = prevPro * product[i];
            prevPro *= nums[i];
        }
        
        return result;
    }
}

//或者构建一个从前往后的预处理数组的方法，只需要constant space
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        
        return res;
    }
}