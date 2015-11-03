Leetcode 164 - Maximum Gap - Pigeon Hole Principle.java

import java.util.*;

public class Solution {
    public static void main(String[] args){
        int[] nums = {3,6,9,1};
        int maxGap = maximumGap(nums);
        System.out.println("");
        System.out.println("max gap is " + maxGap);
        
    }
  
    public static int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        
        int len = nums.length;
        int peak = Integer.MIN_VALUE;
        int valley = Integer.MAX_VALUE;
        for(int i=0; i<len; i++){
            peak = Math.max(peak, nums[i]);
            valley = Math.min(valley, nums[i]); 
        }
        
        double averGap = (double)(peak - valley) / (double)(len - 1);
        if(averGap == 0) return 0;
        int[] maxBucket = new int[len];
        int[] minBucket = new int[len];
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        for(int i=0; i<len; i++){
            int index = (int)((nums[i] - valley)/ averGap);
            maxBucket[index] = Math.max(maxBucket[index], nums[i]);
            minBucket[index] = Math.min(minBucket[index], nums[i]);
        }
        
        for(int i=0; i<maxBucket.length; i++){
            System.out.print(maxBucket[i] + ", ");
        }
      
        System.out.println("");
      
        for(int i=0; i<minBucket.length; i++){
            System.out.print(minBucket[i] + ", ");
        }

        int maxGap = 0;
        int prev = maxBucket[0];
        for(int i=1; i<len; i++){
            if(minBucket[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, minBucket[i] - prev);
            prev = maxBucket[i];
        }
        // 这里必须使用prev来keep，否则结合 continue 会出问题
        
        return maxGap;
    }
}