//Lintcode 062 - Search in Rotated Sorted Array.java
//http://www.lintcode.com/en/problem/search-in-rotated-sorted-array/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        // 注意与 159. Find Minimum in Rotated Sorted Array 比较
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int start = 0, end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            
            if (A[start] < A[mid]) {  //no rotate point in the left part
                if(A[start] <= target && target < A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else { //rotate point in the left part
                if(A[mid] < target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        if (A[start] == target) {
            return start;
        } else if (A[end] == target){
            return end;
        } else {
            return -1;
        }
    }
}
