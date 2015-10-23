//Leetcode 062 - Unique Path - 直接看64的DP解法.java 

public class Solution {
    public static void main(String[] args){
        System.out.println(uniquePaths(3, 7)+ "");
    }
    public static int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        
        int[] res = new int[n]; 
        res[0] = 1;
        
        for(int i=0; i<m; i++){
            for(int j=1; j<n; j++){
                res[j] = res[j-1] + res[j];
            }
        }
        return res[n-1];
    }
}