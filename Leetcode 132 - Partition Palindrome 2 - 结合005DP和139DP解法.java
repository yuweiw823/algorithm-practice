//Leetcode 132 - Partition Palindrome 2 - 结合005DP和139DP解法.java
//切多少刀可以构成回文，结合139word break和005 DP 的方法
public class Solution {
    public int minCut(String s) {
        if(s==null || s.length() ==0)return 0;
        int[] res = new int[s.length()+1];
        boolean[][] dict = isPalindrome(s);
        res[0] = 0;
        
        for(int i=0; i<s.length(); i++){
            res[i+1] = i+1;             //如果没有回文，那么就是每个字符切一刀
            for(int j=0;j<=i; j++){
                if(dict[j][i]){
                    res[i+1] = Math.min(res[i+1], res[j]+1);
                }
            }
        }
        return res[s.length()]-1;
    }
    
    public boolean[][] isPalindrome(String s){
        boolean[][] dict = new boolean[s.length()][s.length()];
        
        for(int i=s.length()-1;i>=0; i--){
            for(int j=i; j<s.length(); j++){
                dict[i][j] = (s.charAt(i) == s.charAt(j) && (j-i<3 || dict[i+1][j-1]));
            }
        }
        return dict;
    }
}