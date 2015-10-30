//Leetcode 028 - Implement strStr().java

public class Solution {
    public static void main(String[] agrs){
        String haystack = "qwertyu";
        String needle = "rty";
        int res = strStr(haystack, needle);
        System.out.println(res);
    }
  
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if(haystack == null || haystack.length() == 0) return -1;
        
        
        for(int i=0; ; i++){   //先循环 haystack
            for(int j=0; ; j++){ // 再循环 needle
                if(j == needle.length()) return i;  //成功
                if(i+j == haystack.length()) return -1; //to the end can not find a value
                if(needle.charAt(j) != haystack.charAt(i+j)) break; 
            }
        }
    }
}