Leetcode 125 - Valid Palindrome - 字符串回文.java

public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null) return false;
        String s1 = s.toLowerCase();   //重要！

        int len = s1.length();
        int i = 0;
        int j = len-1;
        
        while(i<j){
            while(!isValidChar(s1.charAt(i)) && (i<j)) i++;
            while(!isValidChar(s1.charAt(j)) && (i<j)) j--;
            if(s1.charAt(i) != s1.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
     public boolean isValidChar(char c){
         if((c-'a'>=0 && c-'a'<=25 ) || (c-'0'>=0 && c-'0'<=9)) return true;
         return false;
     }
}