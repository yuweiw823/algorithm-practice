//Leetcode 063 - Unique Path 2 - 直接看64的DP解法.java 

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