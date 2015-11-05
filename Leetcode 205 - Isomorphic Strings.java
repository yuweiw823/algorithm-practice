Leetcode 205 - Isomorphic Strings.java


方法1：开一个HashMap
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        
        for(int i=0; i<s.length(); i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if(map.containsKey(s1)){
                if(t1 != map.get(s1)) return false;
            } else if(map.containsValue(t1)){
                return false;
            } else {
                map.put(s1, t1);
            }
        }
        return true;
    }
}

方法2：
开两个数组，记录每个字符第一次出现的位置，如果不一样，则为false
e.g.
               [a b c d e f g h i j k l m n o p q r s t u v w x y z]
paper      [2          3                           1   4                       ]
title         [            4        2     3                     1                  ]

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] map1 = new int[128];
        int[] map2 = new int[128];       
        
        for(int i=0; i<s.length(); i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if(map1[s1] !=map2[t1]) return false;
            map1[s1] = map2[t1] = i+1;
        }
        return true;
    }


// 衍生：
// "cat cat dog", "aab" -> true
// "cat cat dog", "aba" -> false
// 注意 cat dog cat", "aaa" -> false 这种情况

public class Solution {
    public static void main(String[] args){
        boolean res = isIsomorphic("cat cat cat", "aab");
        System.out.println(res);
    }
    
    public static boolean isIsomorphic(String s, String t) {
        HashMap<String, Character> map = new HashMap<String, Character>();
        String[] strs = s.split(" ");

        for(int i=0; i<t.length(); i++){
            String s1 = strs[i];
            char t1 = t.charAt(i);
            if(map.containsKey(s1)){
                if(map.get(s1)!=t1 ) return false;
            } else if (map.containsValue(t1)){
                return false ;
            } else {
                map.put( s1, t1);
            }
        }
        return true;
    }
}