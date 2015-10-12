//Leetcode 007 - Reverse Integer.java

public class Solution {
    public static void main (String[] args){
        int result = reverse(345);
        System.out.println(result + "");
      
    }
    
    //不需要注意符号
    public static int reverse(int x){
        int result = 0;
        while(x != 0){
            //注意！注意！溢出
            if(Math.abs(result) > (Integer.MAX_VALUE)) return 0;
            result = result * 10 + x % 10;  //重点语句！！背下来！！！
            x = x / 10;
        }
        return result;
    }
}