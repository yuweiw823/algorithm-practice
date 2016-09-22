Leetcode 151 - Reverse Words in a String.java

public class Solution {
    public static void main(String[] args){
        String res = reverseWords("a  ba");
        System.out.println(res);
    }
    
    public static String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        s = s.trim();
        StringBuffer sb = new StringBuffer();
        int j = s.length(); // j used to check the endpoint of substring
        
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == ' '){
                j = i;
            } else if(i==0 || s.charAt(i-1) == ' '){
                if(sb.length() != 0) sb.append(' ');
                sb.append(s.substring(i, j));
            }
        }
        return sb.toString();
    }
}

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