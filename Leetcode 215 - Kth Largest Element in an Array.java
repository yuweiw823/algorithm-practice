Leetcode 215 - Kth Largest Element in an Array.java

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) {
            return -1;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    
    public void quickSort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        
        int left = start;
        int right = end;
        int pivot = nums[start + (end - start) / 2];
        while(left <= right) {
            while(left <= right && nums[left] < pivot) {
                left++;
            }
            while(left <= right && nums[right] > pivot) {
                right--;
            }
            if(left <= right) {
                swap(left, right, nums);
                left++;
                right--;
            }
        }
        quickSort(nums, start, right);
        quickSort(nums, left, end);
    }
    
    public void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
}


//Quick Select 直接看这个
https://discuss.leetcode.com/topic/18662/ac-clean-quickselect-java-solution-avg-o-n-time


import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
      Solution sol = new Solution();
      int[] nums = {4,1,3,5,6,8,4,3,6};
      int result = sol.findKthLargest(nums, 6);
      System.out.println("Result = " + result);
      
      for(int i = 0; i < nums.length; i++) {
        System.out.print(nums[i] + ",");
      }
      
    }
    
  public int findKthLargest(int[] a, int k) {
    int n = a.length;
    int p = quickSelect(a, 0, n - 1, n - k + 1);
    return a[p];
  }
  
  // return the index of the kth smallest number
  int quickSelect(int[] a, int lo, int hi, int k) {
    // use quick sort's idea
    // put nums that are <= pivot to the left
    // put nums that are  > pivot to the right
    int i = lo, j = hi, pivot = a[hi];
    while (i < j) {
      if (a[i++] > pivot) {
          j--;
          i--;
          swap(a, i, j);
      }
    }
    swap(a, i, hi);
    
    // count the nums that are <= pivot from lo
    int m = i - lo + 1;
    
    // pivot is the one!
    if (m == k)     return i;
    // pivot is too big, so it must be on the left
    else if (m > k) return quickSelect(a, lo, i - 1, k);
    // pivot is too small, so it must be on the right
    else            return quickSelect(a, i + 1, hi, k - m);
  }
  
  void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
};
