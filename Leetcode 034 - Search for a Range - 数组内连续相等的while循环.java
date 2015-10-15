//Leetcode 034 - Search for a Range - 数组内连续相等的while循环.java

public class Solution {
    public static void main(String[] agrs){
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(result[0] + " "+ result[1]);
    }
    
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length==0||nums==null) return res;
        
        int index1 = BiSearch(nums, 0, nums.length-1, target);
        if(index1 == -1) return res;
        else res[0] = res[1] = index1;

        int index2=index1;
        //判断连续相等的while循环！记住！
        while(index2<nums.length-1){
            if(nums[index2+1] != target) break; //注意这里的+1
            else index2++;
        }
        res[1] = index2;
        return res;
    }
    
    public static int BiSearch(int[] A, int start, int end, int key){
        int L = start, R =end;
        while(L<R){
            int M = (L+R)/2;
            if(A[M] < key){
                L = M+1;
            } else {
                R = M;
            }
        }
        return (L==R && A[L] == key) ? L : -1;
    }
}