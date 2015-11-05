Leetcode 161 - One Edit Distance.java


Given two strings S and T, determine if they are both one edit distance apart.


public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1) return false;
        int i = 0, j = 0;
        int err = 0;
        
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) != t.charAt(j)){
                err++;
                if(err > 1) return false;
                if(s.length() > t.length()){
                    j--;    //不能i++
                } else if(s.length() < t.length()){
                    i--;    //不能j++
                }
            }
            i++;
            j++;
        }
        return err == 1 || (err == 0 && t.length() != s.length());
    }
}