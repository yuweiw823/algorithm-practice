Leetcode 168 - Excel Sheet Column Title - 有关怎么转进制.java
// 倒着取余！倒着取余！倒着取余！
public class Solution {
    public String convertToTitle(int n) {
        if(n<= 0) return "";
        StringBuffer res = new StringBuffer();
        
        while(n > 0){
            n = n - 1;
            int digit = n % 26;
            n = n / 26;
            res.insert(0, (char)(digit + 'A'));
        }
        
        return res.toString();
    }
}