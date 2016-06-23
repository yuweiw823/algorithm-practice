//Leetcode 033 - Search in Rotated Sorted Array - Greed BiSearch.java

//Lintcode 062 - Search in Rotated Sorted Array.java
//http://www.lintcode.com/en/problem/search-in-rotated-sorted-array/
//Leetcode 033 - Search in Rotated Sorted Array.java
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



// 以前的方法 - 什么鬼……
// 先使用贪心法找到top点，然后两边分别用 BiSearch
// 注意通过 top 点的位置，判断 array 是否翻转过，如果没有翻转过，用正常 Bisearch 即可； 

public class Solution {
    public static void main(String[] args){
        int[] nums = {1};
        int res = search(nums, 0);
        System.out.println(res + "");
    }
  
    public static int search(int[] nums, int target) {
        int L=0; int R=nums.length-1;
        while(L<R){
            if(nums[L] < nums[R]){
                L++;
            } else {
                R--;
            }
        }
        //here we find the top
        int top = L;
        int res;
        if(top!=nums.length-1){  //if the array is rotated
            int findLpart = BiSearch(nums, 0, top, target);
            int findRpart = BiSearch(nums, top+1, nums.length-1, target);
            res = (findLpart == -1 ? findRpart : findLpart);
        } else {  //if the array is ASEC sorted 
            res = BiSearch(nums, 0, top, target);
        }
        
        return res;
    }
    
    public static int BiSearch(int[] A, int start, int end, int key){
        int L = start;
        int R = end;
        
        while(L<R){
            int M = L + (R-L)/2;
            if(A[M] < key) {
                L = M + 1;
            } else {
                R = M;
            }
        }
        return (L == R && A[L] == key) ? L : -1;
    }
}