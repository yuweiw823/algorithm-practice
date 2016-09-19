Lintcode 059 - 3Sum Closest.java

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] nums, int target) {
        // write your code here
        if(nums == null || nums.length < 3) {
            return 0;
        }
        
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];
        
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            // 整个循环必须从头到尾全部走一遍。不存在找到一个最优解直接quit的情况
            // [1, 2, 4, 6, 8, 15]
            // 1 + 2 + 15 = 18
            // 4 + 6 + 8 = 18
            // 所以中间某三个数相加可能会出现同样的结。
            // keep一个 best 值，每次都跟它比较。
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if(Math.abs(target - sum) < Math.abs(target - bestSum)) {
                    bestSum = sum;
                } // 作用  记录  bestSum  而已 ， 把 把所有 

                if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return bestSum;
        
        
    }
}
