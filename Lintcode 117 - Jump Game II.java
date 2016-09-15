Lintcode - 117 - Jump Game II.java
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
Example
Given array A = [2,3,1,1,4]
The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then3 steps to the last index.)
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        
        int len = A.length;
        int[] minSteps = new int[len];
        minSteps[0] = 0;
        
        for(int i = 1; i < len; i++){
            minSteps[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                //index j is reachable itself, and can reach i from j
                if(minSteps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    minSteps[i] = minSteps[j] + 1;
                    break;  //一定要加 break
                }
            }
        }
        
        return minSteps[len - 1];
        
    }
}

 
