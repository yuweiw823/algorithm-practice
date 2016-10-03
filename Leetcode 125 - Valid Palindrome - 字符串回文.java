Leetcode 125 - Valid Palindrome - 字符串回文.java

public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        
        String str = s.toLowerCase();
        
        int start = 0;
        int end = str.length() - 1;
        
        while(start < end) {
            while(!isValidChar(str.charAt(start)) && (start < end)) {
                start++;
            }

            while(!isValidChar(str.charAt(end)) && (start < end)) {
                end--;
            }

            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
    
    public boolean isValidChar(char c) {
        int i = c - 'a';
        if((c-'a'>=0 && c-'a'<=25 ) || (c-'0'>=0 && c-'0'<=9)) {
            return true;
        }
        return false;
    }
}