Lintcode 089 - First Missing Positive.java

public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
            return 1;   
        }
        
        if(A.length == 1 && A[0] != 1) {
            return 1;
        }
        
        for(int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != i + 1) { // 注意
                int tmp = A[i];
                if(A[tmp - 1] == tmp) {
                    break;
                } else {
                    A[i] = A[tmp - 1];
                    A[tmp - 1] = tmp;
                }
            }
        }

        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                return (i + 1);
            }
        }
        
        return A.length + 1;
    }
}