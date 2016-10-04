Leetcode 258 - Add Digits.java

public class Solution {
    public int addDigits(int num) {
        while(num >= 10) {
            num = num % 10 + num / 10;
        }
        return num;
    }
}