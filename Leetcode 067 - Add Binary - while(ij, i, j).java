//Leetcode 067 - Add Binary - while(ij, i, j).java

public class Solution {
    public static void main(String[] args){
        String a = "0";
        String b = "0";
        String res = addBinary(a, b);
        System.out.println(res);
    }

    //使用三个 while 循环控制，while(i, j) while(i) while(j)
    public static String addBinary(String a, String b) {
        if(a==null || a.length()==0) return b;
        if(b==null || b.length()==0) return a;
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        StringBuilder res = new StringBuilder();

        while(i >= 0 && j>= 0){
            int digit = (a.charAt(i)-'0'+b.charAt(j)-'0') + carry;
            carry = digit / 2;
            digit = digit % 2;
            res.append(digit);
            i--;
            j--;
        }
        while(i >= 0){
            int digit = (a.charAt(i)-'0') + carry;
            carry = digit / 2;
            digit = digit % 2;
            res.append(digit);
            i--;
        }
        while(j >= 0){
            int digit = (b.charAt(j)-'0') + carry;
            carry = digit/2;
            digit = digit%2;
            res.append(digit);
            j--;
        }
        if(carry>0){
            res.append(carry);
        }
        return res.reverse().toString();
    }

    

    //自己写的解，但不够好。
    public static String addBinary(String a, String b) {
        StringBuffer res = new StringBuffer();
        int a_len = a.length();
        int b_len = b.length();
        int min_len = Math.min(a_len, b_len);
        
        int i = 0;
        int num = 0, carry = 0, digit = 0;
        while(i<min_len){
            num = (a.charAt(a_len-1-i)-'0') + (b.charAt(b_len-1-i)-'0') + carry;
            carry = num / 2;
            digit = num % 2; 
            res.insert(0, digit);
            i++;
        }
        //after this point, i = min_len

        String c = (a_len > b_len) ? a : b;
        int c_len = c.length();
        
        while(i<c_len){
            num = (c.charAt(c_len-1-i) - '0') + carry;
            carry = num / 2;
            digit = num % 2;
            res.insert(0, digit);
            i++;
        }
        
        if(carry > 0) res.insert(0, 1);
        
        return res.toString();
    }
}