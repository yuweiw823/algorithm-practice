//Leetcode 088 - Merge Sorted Array - 从右向左扫.java

// 维护三个index，分别对应数组A，数组B，和结果数组。
// 然后A和B同时从后往前扫，每次迭代中A和B指向的元素大的便加入结果数组中，然后index-1，另一个不动。
// 从后往前扫是因为这个题目中结果仍然放在A中，如果从前扫会有覆盖掉未检查的元素的可能性。
public class Solution {
    public static void main(String[] args) {
        int[] A = {1,3,5,9,0,0,0};
        int[] B = {2,4,6};

        merge(A, A.length-B.length, B, B.length);

        for(Integer i : A){
          System.out.println(i);
        }
    }
  
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m+n-1;
        m--;
        n--;
        
        while(m>=0 && n>=0){
            if(nums1[m] >= nums2[n]){
                nums1[index--] = nums1[m--];
            } else {
                nums1[index--] = nums2[n--];
            }
        }
        
        while(n>=0) {
            nums1[index--] = nums2[n--];
        }
    }   
}

//Lintcode
class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = m - 1;
        int j = n - 1;
        int index = A.length - 1;
        
        while(i >= 0 && j >= 0) {
            if(A[i] > B[j]) {
                A[index--] = A[i--];  //都是先操作然后再--
            } else {
                A[index--] = B[j--];
            }
        }
        
        while(i >= 0) {
            A[index--] = A[i--];
        }
        while(j >= 0) {
            A[index--] = B[j--];
        }
    }
}