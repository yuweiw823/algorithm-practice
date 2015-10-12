//Leetcode 009 - Palindrome Number.java

public class Solution {
    public static void main (String[] args){
        boolean res1 = isPalindrome_ReversedInt(1234554321);
        boolean res2 = isPalindrome_String(1234554321);
        boolean res3 = isPalindrome_CompareDigits(1234554321);
        System.out.println(res1 + " " + res2 + " " + res3);
      
    }

    //反转整数，然后比较
    public static boolean isPalindrome_ReversedInt(int x) {
        if(x < 0) return false;
        
        int origin = x;
        int reversed = 0;
        while(x > 0){
            reversed = reversed * 10 + x % 10;
            x = x / 10; 
        }
        
        if(origin == reversed) return true;
        else return false;
    }
    //转化为String，然后前后两个指针比较
    public static boolean isPalindrome_String(int x) {
        if(x < 0) return false;
        String s = new String();
        s = x + "";

        int i = 0;
        int len = s.length()-1;
        while(i <= len/2){
            if(s.charAt(i) != s.charAt(len-i)){
                return false;
            }
            i++;
        }
        return true;
    }
    //首位数和个位数逐个比较
    public static boolean isPalindrome_CompareDigits(int x) {
        if(x < 0) return false;
        //设置一个x1，计算digit
        int x1 = x;
        int digit = 1;
        while(x1 > 0){
            if(x1/10 > 0) digit *= 10;
            x1 /= 10; 
        }
        //取首位数和个位数比较
        int x2 = x;
        int L = 0;
        int R = 0;
        while(x2 > 0){
            R = x2 % 10;
            L = x2 / digit;
            if (L != R) return false;
            x2 = (x2/10) - R*(digit/10);
            //   = (323/10) - 3*(100/10)
            //   = 32-3*10
            //   = 2
            digit /= 100;
        }
        return true;
    }
}