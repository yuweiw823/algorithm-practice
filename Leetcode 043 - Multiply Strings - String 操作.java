//Leetcode 043 - Multiply Strings - String 操作.java
//注意点：
// 1. resNum[i+j] += digit1 * digit2;
// 2. 从最后个位开始
// 3. carry
// 4. 首位 0

public class Solution {
    public static void main(String[] args){
        String num1 = "0";
        String num2 = "9766";
        String res = multiply(num1, num2);
        System.out.println(res);
    }
  
    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] resNum = new int[len1+len2-1];
        StringBuffer result = new StringBuffer(); 
        
        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                resNum[i+j] += digit1 * digit2;
            }
        }
        // 例：23 * 76
        // 2 * 7 = 14
        // 2 * 6 + 3 * 7 = 33
        // 3 * 6 = 18
        // resNum[14, 33, 18]
        
        int carry = 0;
        int num = 0;
        int digit = 0;
        // 从最后一位18开始加入StringBuffer，注意 k=len1+len2-2, k>=0
        for(int k=len1+len2-2;k>=0; k--){
            num = resNum[k]+carry;
            carry = num / 10;
            digit = num % 10;
            result.insert(0, Integer.toString(digit));

        }
        
        //可能有进位没有全部加上的情况
        if (carry>0){
            result.insert(0, Integer.toString(carry));
        }
        
        //处理首位的 0，例如 9999 * 0 = 0000
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
      
        return result.length() == 0 ? "0" : result.toString();
    }
}