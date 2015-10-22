//Leetcode 058 - Length of Last Word - 两个指针找LR.java

public class Solution {
    public static void main(String[] args){
        System.out.println(lengthOfLastWord("Hello World!")+ "");
    }
    
    public static  int lengthOfLastWord(String s) {
        //使用两个指针，从最右开始扫，找到最后一个词的 L 和 R
        if(s.length()==0 || s==null) return 0;
        
        int R = s.length()-1;
        while(R>=0 && s.charAt(R) == ' '){
            R--;
        }
        
        int L = R;
        while(L>=0 && s.charAt(L) != ' '){
            L--;
        }
        
        return R-L;
    }
}