//Lintcode 061 - Search for a Range.java
//http://www.lintcode.com/en/problem/search-for-a-range/
//Leetcode 034
//https://leetcode.com/problems/search-for-a-range/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = {-1, -1};
        if (A == null || A.length == 0) {
            return result;
        }
        
        int start = 0, end = A.length - 1;
        if(A[start] > target || A[end] < target) {
            return result;
        }
        int pos = -1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                pos = mid;
                break;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if(pos == -1) {
            if (A[start] != target && A[end] != target) {
                return result;
            } else {
                pos = (A[start] == target ? start : end);
            }
        }

        //find first target in the range A[start] ~ A[pos]
        //find  last target in the range A[pos] ~ A[end]
        int i = start, j = pos;
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (A[mid] == target) {
                j = mid;
            } else {
                i = mid;
            }
        }
        result[0] = A[i] == target ? i : j;
        
        i = pos; j = end;
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (A[mid] == target) {
                i = mid;
            } else {
                j = mid;
            }
        }
        result[1] = A[j] == target ? j : i;
        
        return result;
    }
}
