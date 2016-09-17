Lintcode 158 - Two Strings Are Anagrams.java

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
     
    //使用HashMap 记录 Char 及出现过的次数 
    public boolean anagram(String s, String t) {
        // write your code here
        if(s == null && t == null) {
            return true;
        }
        
        if((s == null && t != null) || (s != null && t == null)) {
            return false;
        }
        
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        for(char c : sChars) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        
        for(char c : tChars) {
            if(map.containsKey(c)) {
                int showTimes = map.get(c);
                if(showTimes <= 0) {
                    return false;
                }
                map.put(c, showTimes - 1);
            } else {
                return false;
            }
        }
        
        return true;
    }
};