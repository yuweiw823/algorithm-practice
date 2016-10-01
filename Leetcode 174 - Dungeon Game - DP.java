Leetcode 174 - Dungeon Game - DP.java
https://discuss.leetcode.com/topic/7633/best-solution-i-have-found-with-explanations/2

    int calculateMinimumHP(vector &dungeon) {
    int m = dungeon.size();
    int n = dungeon[0].size();
    vector minInitHealth(m, vector<int>(n,0));
    for(int i=m-1; i>=0; i--)
    {
        for (int j=n-1; j>=0; j--)
        {
            if (i == m-1 && j == n-1)
            {
                minInitHealth[i][j] = max(1, 1 - dungeon[i][j]);
            }  
            else if (i == m-1)
            {
                minInitHealth[i][j] = max(1, minInitHealth[i][j+1] - dungeon[i][j]);
            }  
            else if (j == n-1)
            {
                minInitHealth[i][j] = max(1, minInitHealth[i+1][j] - dungeon[i][j]);
            }  
            else
            {
                minInitHealth[i][j] = max(1, min(minInitHealth[i+1][j],minInitHealth[i][j+1]) - dungeon[i][j]);
            }  
        }
    }
    
    return  minInitHealth[0][0];
}