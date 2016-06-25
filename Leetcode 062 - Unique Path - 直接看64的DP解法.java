//Leetcode 062 - Unique Path - 直接看64的DP解法.java 
//Lintcode 114 - Unique Path.java
http://www.lintcode.com/en/problem/unique-paths/

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        int[][] A = new int[m][n];
        
        for(int i = 0; i < m; i++){
            A[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            A[0][j] = 1;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                A[i][j] = A[i-1][j] + A[i][j-1];
            }
        }
        
        return A[m-1][n-1];
    }
}

//舍弃这种不直观的做法
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