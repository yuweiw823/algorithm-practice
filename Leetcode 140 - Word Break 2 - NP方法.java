Leetcode 140 - Word Break 2 - NP方法.java

import java.util.*;

public class Solution {
    public static void main(String[] args){
        String s = "catsanddog";
        HashSet<String> wordDict = new HashSet<String>(){{
            add("cat"); add("cats"); add("and"); add("sand"); add("dog");
            add("ca"); add("tsandd"); add("og");
        }};
        
        List<String> res = wordBreak(s, wordDict);
        System.out.println(res);
    }
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        
        npHelper(s, wordDict, 0, new StringBuffer(), res);
        return res;
    }
    
    public static void npHelper(String s, Set<String> wordDict, int start, StringBuffer item, List<String> res){
        if(start == s.length()){
            res.add(item.toString());
            return;
        }
        for(int i=start; i<s.length(); i++){
            String str = s.substring(start, i+1);
            if(wordDict.contains(str)){
                if(item.length() > 0){
                    item.append(" ");
                }
                item.append(str);
                npHelper(s, wordDict, i+1, item, res);
                item.setLength(start);
            }
        }
    }
}