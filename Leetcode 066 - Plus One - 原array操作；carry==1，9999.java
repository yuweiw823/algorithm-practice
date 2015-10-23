//Leetcode 066 - Plus One - 原array操作，carry==1，9999.java

public class Solution {
    public static void main(String[] args){
        int[] digits = {3,2,5,2,9};
        int[] res = plusOne(digits);
        for(Integer i: res){
            System.out.print(i+",");
        }
    }
    public int[] plusOne(int[] digits) {
        int carry = 1;
        //直接在原array上相加即可
        for(int i=digits.length-1; i>=0; i--){
            int resDigit = carry + digits[i];
            digits[i] = resDigit % 10;
            carry = resDigit / 10;
        }
        if (carry == 1) {
        //注意：如果真的遇到carry==1，则digits本身必是 99999....，直接返回res = 1000000....
            int[] res = new int[digits.length+1];
            res[0] = carry;
            return res;
        } else {
            return digits;
        }
    }
}