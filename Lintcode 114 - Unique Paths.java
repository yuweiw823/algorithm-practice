Lintcode 114 - Unique Paths.java
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
m and n will be at most 100.
Example
1,1	1,2	1,3	1,4	1,5	1,6	1,7
2,1						
3,1						3,7
Above is a 3 x 7 grid. How many possible unique paths are there?
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
