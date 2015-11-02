Leetcode 131 - Partition Palindrome 1 - 结合005的DP解法.java

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) return res;
        List<String> item = new ArrayList<String>();
        boolean[][] dict = isPalindrome(s);
        npHelper(s, dict, 0, item, res);
        return res;
    }
    
    public void npHelper(String s, boolean[][] dict, int start, List<String> item, List<List<String>> res){
        if(start == s.length()) {
            res.add(new ArrayList<String>(item));
            return;
        }
        for(int i=start; i<s.length(); i++){
            if(dict[start][i]){
                item.add(s.substring(start, i+1));
                npHelper(s, dict, i+1, item, res);
                item.remove(item.size()-1);
            }
        }
    }
    
    public boolean[][] isPalindrome(String s){
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i=len-1; i>=0; i--){  //i从前往后
            for(int j=i; j<len; j++){  //j从后往前
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j-i<3 || dp[i+1][j-1]));
            }
        }
        return dp;
    }
}