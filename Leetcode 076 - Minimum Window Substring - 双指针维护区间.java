// Leetcode 076 - Minimum Window Substring - 双指针维护区间.java

// 双指针，动态维护一个区间。
// L = 0， R = 0;
// R不停得往后扫，当扫到一个窗口包含了所有T的字符后，再收缩指针（L向后扫），直到不能再收缩为止（找到一个可行解）。
// L++，R继续向后扫，再次找到包含了所有T的字符的窗口，再收缩。
// 最后记录所有可能状况中窗口最小的。

// 005也使用了这种双指针维护区间的算法

import java.util.*;

public class Solution {
    public static void main(String[] args){
    	String S1 = "ADOBECODEBANC"
		String T1 = "ABC"
        String S2 = "A";
        String T2 = "AA";
        System.out.println(minWindow(S1, T1));
        System.out.println(minWindow(S2, T2));
    }
    
    public static String minWindow(String s, String t) {
    	//dic表示需要的字符及需要的个数,value>=1
        HashMap<Character, Integer> dic = new HashMap<Character, Integer>();
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            if(dic.containsKey(c)) dic.put(c, dic.get(c)+1);
            else dic.put(c, 1);
        }

        int minLen = s.length()+1;
        int minStart = 0;
        int L = 0;
        int count = 0;
        for(int R=0; R<s.length(); R++){
            char charR = s.charAt(R);
            if(dic.containsKey(charR)){
                dic.put(charR, dic.get(charR)-1);
                //dic.get(charR) == 0,表明T里某个所需的char，无论要几个，都已经在区间内。
                if(dic.get(charR) >= 0) count++; 
                //dic.get(charR) < 0，说明多余的char在区间内
                while(count == t.length()){
                    char charL = s.charAt(L);
                    if(dic.containsKey(charL)){ //如果charL在dic中，更新dic，count--，跳出收缩，L++，进入下一个R循环。
                        //取到一个可行解，更新minLen和minStart
                        if(R-L+1 < minLen){
                            minLen = R-L+1;
                            minStart = L;
                        }
                        dic.put(charL, dic.get(charL)+1);
                        if(dic.get(charL) > 0) count--;
                    }
                    //如果charL不在dic中，count不变，区间持续收缩。
                    L++;
                }
            }
        }
        return (minLen > s.length()) ? "" : s.substring(minStart, minStart+minLen);
    }
}