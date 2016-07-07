Lintcode 108 - Palindrome Partitioning II.java
http://www.lintcode.com/en/problem/palindrome-partitioning-ii/
public class Solution {
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 0;
        
        for(int i = 1; i <= n; i++){
            f[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++){
                String cut = s.substring(j, i);
                if(isPanlin(cut)) { //从 j ~ i 能构成几个回文串
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        
        return f[n] - 1;
    }
    
    private boolean isPanlin(String cut) {
        int start = 0, end = cut.length() - 1;
        while(start < end){
            if(cut.charAt(start) == cut.charAt(end)){
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
};