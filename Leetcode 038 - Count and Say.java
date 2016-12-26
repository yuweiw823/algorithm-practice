//Leetcode 038 - Count and Say.java

import java.util.*;

//重写：
public class Solution {
    public static void main(String[] args){
        Solution sol = new Solution();
        String res = sol.countAndSay(4);
        System.out.println(res);
    }

    public String countAndSay(int n) {
        String str = "1";
        if(n == 1) {
            return str;
        }
        
        for(int i = 1; i < n; i++) {
            String temp = countAndSayEach(str);
            str = temp;
        }
        return str;
    }
    
    public String countAndSayEach(String str) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++) {
            int p = i;
            
            while(p < str.length() && str.charAt(p) == str.charAt(i)) {
                p++;
            }
            
            int count = p - i;
            sb.append(count).append(str.charAt(i));
            i = p - 1;
        }
        
        return sb.toString();
    }
}

//以前写的方法：
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