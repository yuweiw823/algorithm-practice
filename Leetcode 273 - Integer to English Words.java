Leetcode 273 - Integer to English Words.java

public class Solution {
    String[] gt100 = {"Hundred", "Thousand", "Million", "Billion"};
    String[] ls100 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] ls20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        
        StringBuffer sb = new StringBuffer();
        
        if(num / 1000000000 > 0) {
            int bdigit = num / 1000000000;
            sb.append(ls20[bdigit]).append(" ").append(gt100[3]).append(" ");
            num = num % 1000000000;
        }
        
        if(num / 1000000 > 0) {
            int part = num / 1000000;
            sb.append(getParts(part)).append(gt100[2]).append(" ");
            num = num % 1000000;
        }
        
        if(num / 1000 > 0) {
            int part = num / 1000;
            sb.append(getParts(part)).append(gt100[1]).append(" ");
            num = num % 1000;
        }
        
        sb.append(getParts(num));
        return sb.toString().trim();
    }
    
    public StringBuffer getParts(int part) {
        StringBuffer sb = new StringBuffer();
        if(part > 99) {
            int hdigit = part / 100;
            sb.append(ls20[hdigit]).append(" ").append(gt100[0]).append(" ");
            part = part % 100;
        }
        
        if(part > 19) {
            int tdigit = part / 10;
            sb.append(ls100[tdigit]).append(" ");
            part = part % 10;
        }
        
        if(part > 0) {
            int digit = part;
            sb.append(ls20[digit]).append(" ");
        }
        
        return sb;
    }
}