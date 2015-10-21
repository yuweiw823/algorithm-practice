//Leetcode 041 - First Missing Positive.java


public class Solution {
    public static void main(String [] agrs){
        int[] nums = {1,3, -1};
        int res = firstMissingPositive(nums);
        System.out.println(res+"");
    }
  

    public static int firstMissingPositive(int[] nums) {
        int[] res = bucketSort(nums);
        for(int i=0; i<res.length; i++){
            if(nums[i]!=i+1) return i+1;
        }
        return res.length + 1; //如果没有找到，那么返回最大数+1
    }
    
    public static int[] bucketSort(int[] A){
        int n = A.length;
        for(int i=0; i<n; i++){
            while(A[i]!=i+1){
                if(A[i]<=0 || A[i]>n || A[i]==A[A[i]-1]) break;
                int temp = A[A[i]-1]; //i 位置上的数本应所在的位置，目前被哪个数占了。
                A[A[i]-1] = A[i]; 
                A[i] = temp;
            }
        }
        return A;
    }
}