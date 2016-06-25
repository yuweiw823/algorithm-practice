//Leetcode 063 - Unique Path 2 - 直接看64的DP解法.java 
//Lintcode 115 - Unique Path 2 - 直接看64的DP解法.java 
http://www.lintcode.com/en/problem/unique-paths-ii/
public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] sum = new int[m][n];
        
        sum[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] == 1 || sum[i-1][0] == 0) {
                sum[i][0] = 0;
            } else {
                sum[i][0] = 1;
            }
        }
        
        for(int j = 1; j < n; j++){
            if(obstacleGrid[0][j] == 1 || sum[0][j - 1] == 0) {
                sum[0][j] = 0;
            } else {
                sum[0][j] = 1;
            }
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    sum[i][j] = 0;
                } else {
                    sum[i][j] = sum[i-1][j] + sum[i][j-1];
                }
            }
        }
        
        return sum[m-1][n-1];
    }
}





//舍弃这种不直观的做法
public class Solution {
    public static void main(String[] args){
        int[][] grid = {{0,0,0}, {0,1,0}, {0,0,0}};
        int res = uniquePathsWithObstacles(grid);
        System.out.println(res + "");
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] res = new int[n];
        
        res[0] = 1;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){ //可能障碍在第一列，所以要从新检查，j 从0开始循环
                if(obstacleGrid[i][j] == 1){
                    res[j] = 0;
                } else if(j>0) {
                    res[j] = res[j] + res[j-1];
                }
            }
        }
        return res[n-1];
    }
}