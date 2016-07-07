Lintcode 119 - Edit Distance.java
//http://www.lintcode.com/en/problem/edit-distance/


i
 M A R T
^ ^ ^ ^ ^
0 1 2 3 4

j
 K A R S A
^ ^ ^ ^ ^ ^
0 1 2 3 4 5

f[i][j]
    j     <=n 
    0 1 2 3 4 5
i 0 0 1 2 3 4 5
  1 1 1 2 3 3 4
  2 2 2 1 2 3 3
  3 3 3 2 1 2 3
  4 4 4 3 2 2 3
<=
m  

关键语句：
if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
    f[i][j] = f[i-1][j-1];
} else {
    f[i][j] = Math.min(f[i-1][j], f[i][j-1], f[i-1][j-1]) + 1;
}


public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        
        int m = word1.length();
        int n = word2.length();
        
        if(m == 0 || n == 0) {
            return Math.abs(m - n);
        }
        
        int[][] f = new int[m+1][n+1];
        
        //这里注意要initilize
        for(int i = 0; i <= m; i++) {
            f[i][0] = i;
        }
        for(int j = 0; j <= n; j++){
            f[0][j] = j;
        }
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i-1][j-1];
                } else {
                    //f[i][j] = Math.min(f[i-1][j], f[i][j-1], f[i-1][j-1]) + 1;
                    //Math.min 不接受三个参数，只要分两步写
                    f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + 1;
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 1);
                }
            }
        }
        
        return f[m][n];
    }
}