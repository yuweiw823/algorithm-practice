Leetcode 096 - Unique Binary Search Trees - 卡特兰树.java


public class Solution {
    public int numTrees(int n) {
        if(n == 0) return 0;

        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for(int m=2; m<=n; m++){
            for(int j=0; j<m; j++){
                res[m] = res[m] + res[m-1-j]*res[j];
            }
        }
        return res[n];
    }
}