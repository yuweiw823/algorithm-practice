Lintcode 139 - Subarray Sum Closest.java

public class Solution {
    class Pair {
        int sum;
        int index;
        public Pair(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }

    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[2];
        if(nums == null || nums.length == 0 || nums.length == 1) {
            return result;
        }
        
        int len = nums.length;
        int preSum = 0;
        Pair[] preSums = new Pair[len+1];
        preSums[0] = new Pair(0, 0);
        for(int i = 1; i <= len; i++) {
            preSum += nums[i-1];
            preSums[i] = new Pair(i, preSum);
        }
        
        Arrays.sort(preSums, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= len; i++) {
            //System.out.println(preSums[i].sum + "," + preSums[i].index);
            int diff = preSums[i].sum - preSums[i-1].sum;
            if(diff < ans) {
                ans = diff;
                result[0] = Math.min(preSums[i].index, preSums[i-1].index);
                result[1] = Math.max(preSums[i].index, preSums[i-1].index) - 1;
            }
        }
        return result;
    }
}
