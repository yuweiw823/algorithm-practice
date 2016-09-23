Leetcode 171 - Excel Sheet Column Number.java

public class Solution {
    public static void main(String[] args){
        String s = "AA";
        int res = titleToNumber(s);
        System.out.println(res + "");
    }
    
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        int digit = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            digit = curr - 'A' + 1;
            result = result * 26 + digit;
        }
        
        return result;
    }
}