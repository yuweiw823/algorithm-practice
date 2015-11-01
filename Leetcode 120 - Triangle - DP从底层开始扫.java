Leetcode 120 - Triangle - DP从底层开始扫.java


// sum[i][j] = Math.min(sum[i+1][j], sum[i+1][j+1]) + triangle[i][j];

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