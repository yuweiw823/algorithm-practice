Leetcode 186 - Reverse Words in a String 2.java

public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) {
            return;
        }
        
        for(int i = s.length - 1; i >= 0; i--) {
            if(s[i] == ' ') {
                continue;
            }
            
            int end = i;
            while(i >= 0 && s[i] != ' ') {
                i--;
            }
            
            int start = i;
            reverseWord(s, start + 1, end);
        }
        reverseWord(s, 0, s.length - 1);
    }
    
    public void reverseWord(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}