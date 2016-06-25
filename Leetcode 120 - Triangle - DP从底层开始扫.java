Leetcode 120 - Triangle - DP从底层开始扫.java
Lintcode 109
http://www.lintcode.com/en/problem/triangle/
// sum[i][j] = Math.min(sum[i+1][j], sum[i+1][j+1]) + triangle[i][j];
//标准动态规划模板写法
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


public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int sum = 0;
        int[] res = new int[triangle.size()];
        //第一遍，先把所有最后一行的数字加入res，
        for(int j=n-1; j>=0; j--){
            res[j] = triangle.get(n-1).get(j);
        }
        //第二遍，从底层开始，DP
        for(int i=n-2; i>=0; i--){
            for(int j = 0; j<=i; j++){
                res[j] = Math.min(res[j], res[j+1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}