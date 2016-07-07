Lintcode 029 - Interleaving String.java
http://www.lintcode.com/en/problem/interleaving-string/

关键语句：
    f[i][j] = (f[i-1][j] && (s1.charAt(i-1) == s3.charAt(p-1))) ||
              (f[i][j-1] && (s2.charAt(j-1) == s3.charAt(p-1)));

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if(s1 == null || s2 == null || s3 == null) {
            return false;
        }
        
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        
        if(m + n != l){
            return false;
        }
        
        boolean[][] f = new boolean[m + 1][n + 1];
        
        //Initilize:
        f[0][0] = true;
        
        for(int i = 1; i <= m; i++) {
            if(s1.charAt(i - 1) == s3.charAt(i - 1)) {
                f[i][0] = true;
            } else {
                break;
            }
        }
        
        for(int j = 1; j <= n; j++) {
            if(s2.charAt(j - 1) == s3.charAt(j - 1)) {
                f[0][j] = true;
            } else {
                break;
            }
        }
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                int p = i + j;
                f[i][j] = (f[i-1][j] && (s1.charAt(i-1) == s3.charAt(p-1))) ||
                          (f[i][j-1] && (s2.charAt(j-1) == s3.charAt(p-1)));
            }
        }
        
        return f[m][n];
    }
}