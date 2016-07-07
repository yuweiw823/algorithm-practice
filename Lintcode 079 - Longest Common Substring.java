Lintcode 079 - Longest Common Substring.java
http://www.lintcode.com/en/problem/longest-common-substring/

i
 A B C D
^ ^ ^ ^ ^
0 1 2 3 4

j
 C B C E
^ ^ ^ ^ ^
0 1 2 3 4

f[i][j]
    j     <=n 
    0 1 2 3 4 
i 0 0 0 0 0 0
  1 0 0 0 0 0
  2 0 0 1 0 0
  3 0 1 0 2 0
  4 0 0 0 0 0
<=
m

longest == 2  

关键语句：
注意一定有这个 longest 来记录最长的
    if(A.charAt(i - 1) == B.charAt(j - 1)) {
        f[i][j] = f[i - 1][j - 1] + 1;
        longest = Math.max(longest, f[i][j]);
    }


public class Solution {
    public int longestCommonSubstring(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }
        
        int m = A.length();
        int n = B.length();
        int[][] f = new int[m + 1][n + 1];
        int longest = 0;
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    longest = Math.max(longest, f[i][j]);
                }
            }
        }
        
        return longest;
    }
}