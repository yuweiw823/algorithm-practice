Lintcode 082 -  Single Number.java

public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        // Write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        int result = 0;
        for(int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }
}