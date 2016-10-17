Leetcode 151 - Reverse Words in a String.java

" " -> ""
//简单版本：直接用.split()，只适用于仅单词间存在空格，且空格仅有一个的情况
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        
        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        
        for(int i = words.length - 1; i >=0; i--) {
                sb.append(words[i]);
                sb.append(" ");
        }
        
        return sb.toString().trim();
    }
}

"  " -> ""
"a   b  " -> "b a"
//以上这种多空格的情况，不能直接用
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                continue;
            };
            
            int end = i;
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            result.append(s.substring(i + 1, end + 1)).append(" ");
        }
        return result.toString().trim();
    }
}

Leetcode 186 原地变换

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