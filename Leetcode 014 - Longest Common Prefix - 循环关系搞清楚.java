//Leetcode 014 - Longest Common Prefix - 循环关系搞清楚.java

public class Solution {
    public static void main(String[] args){
        String[] strs = new String[3];
        strs[0] = "123";
        strs[1] = "12";
        strs[2] = "1234";
        String result = longestCommonPrefix(strs);
        System.out.println(result);
      
    }  
  
    //想清楚两层循环的内外关系
    //strs[j].length() <= i
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return null;
        
        for(int i=0;i<strs[0].length(); i++){
            for(int j=1; j<strs.length; j++){
                if(strs[j].length() <= i || strs[0].charAt(i) != strs[j].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}

//     i=0 i=1 i=2 i=3
// j=0  1   2   3  
// j=1  1   2
// j=2  1   2   3   4