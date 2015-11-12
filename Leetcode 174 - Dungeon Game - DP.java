Leetcode 174 - Dungeon Game - DP.java

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] res = new int[n];
        res[n-1] = Math.max(1, 1-dungeon[m-1][n-1]);
        
        // 如果dungeon[i][j] <= 0,那么res[j+1]- dungeon[i][j] 一定>=1
        // 如果dungeon[i][j] > 0,说明在这一格不会掉血，那个仅有1足够。
        for(int j=n-2; j>=0; j--){
            res[j] = Math.max(1, res[j+1]- dungeon[m-1][j]);
        }//填入第m-1行的情况
        
        if(m == 1) return res[0];
        
        for(int i=m-2; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(j == n-1) res[j] = Math.max(1, res[j]-dungeon[i][j]);
                else res[j] = Math.max(1, Math.min(res[j+1], res[j]) - dungeon[i][j]);
            }
        }
        
        return res[0];
    }
}