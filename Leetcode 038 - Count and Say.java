//Leetcode 038 - Count and Say.java

import java.util.*;

public class Solution {
  
    public static void main(String[] args){
        int n = 2;
        String res = countAndSay(2);
        System.out.println(res);
    }
  
    public static String countAndSay(int n) {
        List<String> reads = new ArrayList<String>();
        String pre_read = "1";
        reads.add(pre_read);
        
        while(n>1){
            String read = singlecountAndSay(pre_read);
            reads.add(read);
            pre_read = read;
            n--;
        }
        return reads.get(reads.size()-1);
    }
    
    public static String singlecountAndSay(String s){
        s = s + "*";  //在最后加一个*以控制index
        StringBuffer read = new StringBuffer();
        
        int count = 1;
        for(int i=0; i<s.length()-1; i++){
            char c = s.charAt(i);
            if(c == s.charAt(i+1)){
                count++;
            }else{
                read.append(count+""+c);
                count = 1;
            }
        }
        return read.toString();
    }
}