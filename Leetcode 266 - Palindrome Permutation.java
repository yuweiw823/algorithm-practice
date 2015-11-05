Leetcode 266 - Palindrome Permutation.java

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        boolean res = canPermutePalindrome2("aabbctd");
        System.out.println(res + "");
    }

    方法1：使用一个int[] 来记录数量，最后从头到尾扫一遍
    public static boolean canPermutePalindrome(String s) {
        int[] countMap = new int[128];
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(countMap[c] == 1){
                countMap[c] = 0;
            }else {
                countMap[c] = 1;
            }
        }
        int checker = 0;
        for(int i=0; i<countMap.length; i++){
            checker += countMap[i];
        }
        return checker<=1;
    }
    
    方法2：使用Hashmap
    public static boolean canPermutePalindrome2(String s){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.remove(c);
            } else {
                map.put(c, 1);
            }
        }
        int total = 0;
        for(int count : map.values()){
            total += count;
            if (total > 1) return false
        }
      
        return total<=1; 
    }
}