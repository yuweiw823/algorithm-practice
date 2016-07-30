Lintcode 109 - Triangle.java
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
Example
Given the following triangle:
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle.length == 0 || triangle[0] == null || triangle.length == 0) {
            return 0;
        }
        
        int n = triangle.length;
        int sum[][] = new int[n][n];
        sum[0][0] = triangle[0][0];
        
        for(int i = 1; i < n; i++){
            sum[i][0] = triangle[i][0] + sum[i-1][0];
            sum[i][i] = triangle[i][i] + sum[i-1][i-1];
        }
        
        for (int i = 1; i < n; i++){
            for(int j = 1; j < i; j++){
                sum[i][j] = triangle[i][j] + Math.min(sum[i-1][j], sum[i-1][j-1]);
            }
        }
        
        int min = sum[n-1][0];
        for(int k = 1; k < n; k++){
            min = Math.min(min, sum[n-1][k]);
        }
        
        return min;
    }
}
