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
            //每当遇到空格，j都会随着i向前挪动。所以连续空格也没有问题。
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