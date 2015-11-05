Leetcode 249 - Group Shifted Strings.java


import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        String[] strings = {"abc", "am"};
        List<List<String>> res = groupStrings(strings);
        System.out.println(res);
    }
    
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0) return res;
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String s : strings){
            int offset = s.charAt(0);
            String key = "";
            for(int i=1; i<s.length(); i++){
                key += (s.charAt(i) - offset + 26) % 26 + ","; //这里必须加, 否则abc和am的key都是12
            }
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            } 
            map.get(key).add(s);  //传入的是引用
        }
        
        for(List<String> item : map.values()){
            Collections.sort(item);
            res.add(item);
        }
        
        return res;
    }
}