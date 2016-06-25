//Leetcode 064 - Minimum Path Sum - 经典DP.java
//Lintcode 110
//http://www.lintcode.com/en/problem/minimum-path-sum/

//标准模板写法
public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        
        for(int i = 1; i < m; i++){
            sum[i][0] = grid[i][0] + sum[i-1][0];
        }
        
        for(int j = 1; j < n; j++){
            sum[0][j] = grid[0][j] + sum[0][j-1];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                sum[i][j] = grid[i][j] + Math.min(sum[i-1][j], sum[i][j-1]);
            }
        }
        return sum[m-1][n-1];
    }
}

//放弃这种写法，不直观
public class Solution {
    public static void main(String[] args){
        int[][] grid = {{2,1,3}, {1,4,2}};
        int res = minPathSum(grid);
        System.out.println(res + "");
    }
    public static int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        //先把第一行的所有格子的值都算出来
        res[0] = grid[0][0];
        for(int j=1; j<n; j++){
            res[j] = res[j-1] + grid[0][j];
        }
        //因为第一行的所有格子都已经算过了，所以 i 从1开始
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                if(j==0) res[j] = res[j] + grid[i][j];
                else res[j] = Math.min(res[j-1], res[j]) + grid[i][j];
            }
        }
        return res[n-1];
    }
}