//Leetcode 001 - Two Sum - unsorted, only hash.java

import java.io.*;
import java.util.*;

//Solution 1 - Hashmap
O(n)
O(n)
class Solution {
    public static void main(String[] args) {
        int[] input = {2,3,7};
        int target = 5;
        int [] result = twoSum(input, target);
        System.out.println(result[0] + " " + result[1]);
    }
    
    public static int[] twoSum(int[] nums, int target) {
        int [] res = {0, 0};
        //value, index
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                res[0] = map.get((target - nums[i])) + 1;
                res[1] = i + 1;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}

//Solution 2 - BinarySearch - sorted array
//具体看 LeetCode 167
import java.io.*;
import java.util.*;

sort一下，O(nlogn+n+logn) = O(nlogn)

// 如果已经sort过了
O(n+logn) = O(n)
O(1)
class Solution {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};
        int target = 26;
        int [] result = twoSum(input, target);
        System.out.println(result[0] + " " + result[1]);
    }
    
    public static int[] twoSum(int[] nums, int target) {
        int [] res = {0, 0};

        for(int i=0; i<nums.length; i++){
            int j = BiSearch(nums, i, nums.length-1, target - nums[i]);
            if(j != -1){
                res[0] = i + 1;
                res[1] = j + 1;
                
            }
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