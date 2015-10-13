//Leetcode 017 - Letter Combinations of a Phone Number - LinkedList.java

import java.util.*;

//LinkedList .remove(), .add(), .peek()
public class Solution {
    public static void main(String[] args){
        String input = "3";
        List<String> res = new ArrayList<String>();
        res = letterCombinations(input);
        System.out.println(res);
    } 
    //1.get the each char in digit - 第一层循环
    //2.get the existing res - 第二层循环
    //3.for each existing res, append new char - 第三层循环
    //4.replace the newRes to the pre-res; 

    //使用了三层循环，使用了LinkedList queue FIFO 的特性来 keep res
    //和 Origin Solution 原理一样，但数据结构更优化
    public static List<String> letterCombinations(String digits) {
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> res = new LinkedList();
        if(digits == null || digits.length() == 0) return res;
        res.add("");
        
        
        for(int i=0; i<digits.length(); i++){     //第一层循环
            int digit = digits.charAt(i) - '0';
            while(res.peek().length() == i){      //第二层循环，注意这个判断条件，非常巧妙
                String t = res.remove();          //reomve() 既得到 prev-res，又 keep 了 queue
                for(char s : mapping[digit].toCharArray()){ //第三层循环
                    res.add(t+s);
                }
            }
        }
        return res;
    }
  
   //Origin Solution - 使用了三层循环，但速度太慢；且ArrayList数据结构不够优化
    public static List<String> letterCombinations(String digits) {
        String[] mapping = new String[]{"0","1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return res;
        res.add("");
      
        for(int i=0; i<digits.length(); i++){  //第一层循环
            int digit = digits.charAt(i) - '0'; 
            List<String> newRes = new ArrayList<String>();

            for(int j=0; j<res.size(); j++){   //第二层循环
                for(int k=0; k<letter.length(); k++){ //第三层循环
                    String newRes_each = res.get(j) + mapping[digit].charAt(k);
                    newRes.add(newRes_each);
                }
                res = newRes;
            }
        }
        return res;
    }
}