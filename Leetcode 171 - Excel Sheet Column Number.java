Leetcode 171 - Excel Sheet Column Number.java

public class Solution {
    public static void main(String[] args){
        String s = "AA";
        int res = titleToNumber(s);
        System.out.println(res + "");
    }
    
    public static int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int digit = c-'A' + 1;
            System.out.println(digit+"");
            res = res * 26 + digit; 
        }
        return res;
    }
}