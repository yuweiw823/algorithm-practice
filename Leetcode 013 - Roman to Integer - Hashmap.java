//Leetcode 013 - Roman to Integer - Hashmap.java
//使用HashMap,只需put 1和5, 通过比较curr位和上一位决定是否减去
//curr > prev ? curr - 2 * prev : curr;

import java.util.*;

public class Solution {
    public static void main(String[] args){
        String s = "XXI";
        int result = romanToInt("IX");
        System.out.println(result + "");
    }
    
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(){{
            put('I', 1); put('V', 5); 
            put('X', 10); put('L', 50); 
            put('C', 100); put('D', 500); 
            put('M', 1000);
        }};
        int num = 0;
        int curr=0, prev=0;
        for(int i=0; i<s.length(); i++){
            curr = map.get(s.charAt(i));
            num += (curr <= prev ? curr : curr - 2 * prev);
            prev = curr;
        }
        return num;
    }
}