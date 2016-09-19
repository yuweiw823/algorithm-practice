Lintcode 183 - Wood Cut.java

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L == null || L.length == 0) {
            return 0;
        }
        
        int maxInArr = L[0];
        int minInArr = L[0];
        int sumOfArr = L[0];
        for(int i = 1; i < L.length; i++) {
            maxInArr = Math.max(maxInArr, L[i]);
            minInArr = Math.min(minInArr, L[i]);
            sumOfArr += L[i];
        }

        int end = Math.max(L[0], sumOfArr / k);
        int start = maxInArr / k;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2; //tryLength
            int pieces = calPieces(L, mid);
            if(pieces >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if(calPieces(L, end) == k) {
            return end;
        } else {
            return start;
        }
    }
    
    public int calPieces(int[] L, int tryLength) {
        int pieces = 0;
        for(int i = 0; i < L.length; i++) {
            pieces += L[i] / tryLength;
        }
        return pieces;
    }
}