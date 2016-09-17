Lintcode 055 - Compare Strings.java

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
     
    //和 158 Two Strings Are Anagrams 一样的算法
    //使用HashMap 记录 Char 及出现过的次数 
    public boolean compareStrings(String A, String B) {
        // write your code here
        if(A == null) {
            return false;
        }
        
        if((A == null && B == null) || (A.length() == 0 && B.length() == 0)) {
            return true;
        }
        
        if(A.length() < B.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        
        for(char a : charA) {
            if(map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        
        for(char b : charB) {
            if(map.containsKey(b)) {
                int showTimes = map.get(b);
                if(showTimes <= 0) {
                    return false;
                }
                map.put(b, showTimes - 1);
            } else {
                return false;
            }
            
        }
        
        return true;
    }
}