//Leetcode 034 - Search Insert Position - Bisearch 找到插入语key的位置.java

public class Solution {
    public static void main(String[] args){
        int[] nums = {1,3,6,7};
        int target = 4;
        int result = searchInsert(nums, target);
        System.out.println(result + "");
      
    }
    public static int searchInsert(int[] nums, int target) {
        int L = 0;
        int R = nums.length-1;
        while(L<R){
            int M = (L+R)/2;
            if(nums[M] < target){
                L = M+1;
            } else {
                R = M;
            }
        }
        return (nums[L] < target) ? L+1 : L;
    }
}

//http://www.lintcode.com/en/problem/search-insert-position/
public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int start = 0, end = A.length - 1;
        // the array A has at least 3 numbers
        while (start + 1 < end) {

            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (target < A[start]) {
            return start;
        } else if (A[end] < target) {
            return end + 1;
        } else if (A[start] == target) {
            return start;
        }
        
        return end;
    }
}
