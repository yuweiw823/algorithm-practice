//Leetcode 005 - Longest Palindromic Substring
//构造一个函数，从当前位向两边移，比较是否相同
//注意奇数和偶数
//注意 start 和 end
//                start = i - (len-1)/2;
//                end = i + len/2;


public class Solution {
    public static void main (String[] args){
        String result = new String();
        result = longestPalindrome("abba45");
        System.out.println(result);
    }
  
    public static String longestPalindrome(String s) {
        if (s.length() == 0 || s == null) return null;
        
        int start = 0, end = 0;
        for(int i=0; i<s.length(); i++){
            int odd_len = expandAroundCenter(s, i, i);
            int even_len = expandAroundCenter(s, i, i+1);
            int len = Math.max(odd_len, even_len);
            if(len > end - start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    public static int expandAroundCenter(String s, int L_start, int R_start){
        int L = L_start;
        int R = R_start;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return (R-L-1);
    }
}