//Leetcode 093 - Restore IP Addresses - NP.java 

import java.util.*;

public class Solution {
    public static void main(String[] args){
        String s = "10223";
        List<String> res = new ArrayList<String>();
        res = restoreIpAddresses(s);
        System.out.println(res);
    }
    
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s==null || s.length()==0 || s.length() > 12) return res;
        findIP(s, 0, 1, "", res);
        return res;

    }
    //                          segment相当N_Queen中的row
    public static void findIP(String s, int index, int segment, String item, List<String> res){
        if(index >= s.length()) return;
        if(segment == 4){
            String str = s.substring(index);
            if(isValidIP(str)){
                res.add(item+str);
            }
            return;
        }
        for(int i=1; i<4 && index+i<=s.length(); i++){
            String str = s.substring(index, index+i);
            if(isValidIP(str)){
                if(segment == 1){
                    item = "";
                }
                findIP(s, index+i, segment+1, item+str+".", res);
            }
        }
    }
    
    public static boolean isValidIP(String str){
        if(str==null || str.length()==0) return false;
        if(str.charAt(0)=='0' && str.length()>1) return false;
        int num = Integer.parseInt(str);
        if(num<0 || num >255) return false;
        return true;
    }
}